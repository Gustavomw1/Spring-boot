const baseUrl = 'http://localhost:8080/api/produtos';

function showToast(message, type = 'success') {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.className = `toast show ${type}`;
    setTimeout(() => {
        toast.classList.remove('show');
    }, 3000);
}

async function addProduct() {
    const name = document.getElementById('name').value.trim();
    const price = parseFloat(document.getElementById('price').value);

    if (!name) {
        showToast('Por favor, insira o nome do produto.', 'error');
        return;
    }
    if (isNaN(price) || price <= 0) {
        showToast('Por favor, insira um preço válido.', 'error');
        return;
    }

    try {
        const response = await fetch(baseUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome: name, preco: price })
        });

        if (!response.ok) {
            const errorText = await response.text();
            console.error('Erro na resposta da API:', errorText);
            throw new Error(errorText || 'Erro na resposta da API');
        }

        const data = await response.json();
        showToast(`Produto inserido com ID: ${data.id}`, 'success');

        document.getElementById('name').value = '';
        document.getElementById('price').value = '';

    } catch (error) {
        console.error('Erro ao inserir produto:', error);
        showToast('Erro ao inserir produto: ' + error.message, 'error');
    }
}

function getProduct() {
    const id = document.getElementById('searchId').value.trim();

    if (!id) {
        showToast('Por favor, insira o ID do produto para busca.', 'error');
        return;
    }

    fetch(`${baseUrl}/${id}`)
        .then(response => {
            if (!response.ok) throw new Error('Produto não encontrado');
            return response.json();
        })
        .then(data => {
            document.getElementById('result').innerHTML =
                `<p><strong>ID:</strong> ${data.id}</p>
                 <p><strong>Nome:</strong> ${data.nome}</p>
                 <p><strong>Preço:</strong> R$ ${data.preco.toFixed(2)}</p>`;
            showToast('Produto encontrado.', 'success');
        })
        .catch(error => {
            document.getElementById('result').innerHTML = '<p>Produto não encontrado.</p>';
            showToast('Produto não encontrado.', 'error');
        });
}

function deleteProduct() {
    const id = document.getElementById('deleteId').value.trim();

    if (!id) {
        showToast('Por favor, insira o ID do produto para deletar.', 'error');
        return;
    }

    fetch(`${baseUrl}/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                showToast('Produto deletado com sucesso!', 'success');
                document.getElementById('deleteId').value = '';
            } else {
                showToast('Erro ao deletar produto.', 'error');
            }
        })
        .catch(error => {
            showToast('Erro ao deletar produto.', 'error');
        });
}
