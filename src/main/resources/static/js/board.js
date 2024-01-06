// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/board/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('inputLarge').value,
                content: document.getElementById('exampleTextarea').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/show/board/${id}`);
            });
    });
}

// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/board/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('게시물이 삭제 되었습니다.');
                location.replace('/show/board')
            })
    })
}

// 생성 기능
const createButton = document.getElementById("create-btn");

if (createButton) {
    createButton.addEventListener("click", event => {
        fetch(`/board/new`, {
            method: "POST",
            headers: {
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("inputLarge").value,
                content: document.getElementById("exampleTextarea").value,
            }),
        })
            .then(() => {
                alert("게시물이 등록되었습니다.");
                location.replace("/show/board");
            });
    });
}