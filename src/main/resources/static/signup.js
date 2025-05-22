window.addEventListener("load", () => {
    let id_check = false;

    function signup() {
        const form = document.getElementById("signup");
        const idValue = form.memberId.value.trim();

        // 아이디 입력 여부 및 길이 체크
        if (!idValue) {
            alert("아이디를 입력해 주시기 바랍니다");
            return;
        }

        if (idValue.length < 4) {
            alert("아이디는 최소 4자리 이상 입력하여야 합니다");
            return;
        }

        if (!id_check) {
            alert("아이디 중복검사를 하셔야 합니다");
            return;
        }

        // 비밀번호와 비밀번호 확인 입력 및 일치 여부 확인
        if (!form.passwd.value || !form.passwd_check.value) {
            alert("비밀번호와 비밀번호 확인을 입력해 주시기 바랍니다");
            return;
        }

        if (form.passwd.value !== form.passwd_check.value) {
            alert("비밀번호와 비밀번호 확인이 일치하도록 입력해 주시기 바랍니다");
            return;
        }

        // 성명 입력 여부 체크
        if (!form.name.value) {
            alert("성명을 입력해 주시기 바랍니다");
            return;
        }

        // 전화번호 입력 여부 체크
        if (!form.phone.value) {
            alert("전화번호를 입력해 주시기 바랍니다");
            return;
        }
		
		if (!form.email.value){
			alert("이메일을 입력해 주시기 바랍니다")
			return;
		}
		
		if (!form.address.value){
			alert("주소를 입력해 주시기 바랍니다")
			return;
		}

        form.submit(); // 폼 제출
    }

    const submit = document.getElementById("signup_button");
    submit.addEventListener("click", e => {
        e.preventDefault();
        signup();
    });

    // 아이디 중복 확인 버튼 클릭 이벤트
    document.getElementById("id_check").addEventListener("click", e => {
        const memberId = document.querySelector("input[name='memberId']").value.trim();

        if (memberId.length < 4) {
            alert("아이디는 최소 4자리 이상이어야 합니다.");
            return;
        }

        const xhr = new XMLHttpRequest();
        xhr.open("GET", `/id_check/${memberId}`, true);

        xhr.onreadystatechange = () => {
            if (xhr.readyState === xhr.DONE) {
                if (xhr.status === 200) {
                    if (xhr.responseText === "OK") {
                        alert("사용 가능한 아이디입니다");
                        id_check = true;
                    } else {
                        alert(xhr.responseText);
                        id_check = false;
                    }
                }
            }
        };

        xhr.send();
    });

    // 아이디 입력 값이 변경되면 id_check 리셋
    document.querySelector("input[name='memberId']").addEventListener("change", e => {
        id_check = false;
    });

    // 비밀번호 숨기기/보이기
    document.querySelectorAll(".passwd").forEach(div => {
        const input = div.querySelector("input[type='password']");
        const view = div.querySelector(".view");

        view.addEventListener("mousedown", e => {
            input.setAttribute("type", "text");
        });

        view.addEventListener("mouseup", e => {
            input.setAttribute("type", "password");
        });
    });
});
