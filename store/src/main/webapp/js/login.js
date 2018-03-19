$('#loginForm,#regForm').bootstrapValidator({
    fields: {
        username: {
            validators: {

                notEmpty: {
                    message: '用户名不能为空.'
                },
                stringLength: {
                    min: 3,
                    max: 80,
                    message: '用户名长度应该在4 - 15之间.'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: '密码不能为空.'
                },
                stringLength: {
                    min: 3,
                    max: 80,
                    message: '密码长度应该在4 - 15之间.'
                }
            }
        }
    }
});

function sendMd5() {
        // var username = $(".username");
        // var password_noMd5 = $(".password_noMd5");
        // var password = $("#password");
        //
        // password.value = '37254660e226ea65ce6f1efd54233424';

    var username = document.getElementById('username');
    var password_input = document.getElementById('password_noMd5');
    var password_md5 = document.getElementById('password_md5');
    password_md5.value =  md5(password_input.value);
    return true;
}