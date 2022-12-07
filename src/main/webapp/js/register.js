var btnregis = document.querySelector('#btnregis')
var flag1 = false
var flag2 = false
var flag3 = false
var flag4 = false
var rg1 = /^1[345789]\d{9}$/;
var txt1 = document.querySelector('#iphone')
var sp1 = document.querySelector('#warn1')
var rg2 = /^(?![a-zA-Z]+$)[a-zA-Z0-9\\W_!@#$%^&*`~()-+=]{8,16}$/;
var txt2 = document.querySelector('#ipass')
var sp2 = document.querySelector('#warn2')
var txt3 = document.querySelector('#ipass2')
var sp3 = document.querySelector('#warn3')
var txt4 = document.querySelector('#iuser')
var sp4 = document.querySelector('#warn4')
var txt5 = document.querySelector('#icode')
var sp5 = document.querySelector('#warn5')
var form = document.querySelector('form')
var checkbtn=document.querySelector('#icheck')
txt1.onblur = function() {
	if (rg1.test(txt1.value)) {
		sp1.style.visibility = "hidden"
		flag1 = true
	} else {
		sp1.innerHTML = "<p>格式错误</p>"
		sp1.style.visibility = "visible"
		flag1 = false
	}
}
txt2.onblur = function() {
	if (rg2.test(txt2.value)) {
		sp2.style.visibility = "hidden"
		flag2 = true
		if (txt2.value == txt3.value) {
			sp3.style.visibility = "hidden"
			flag3 = true
		}
	} else {
		sp2.innerHTML = "<p>格式错误</p>"
		sp2.style.visibility = "visible"
		flag2 = false
	}
}
txt3.onblur = function() {
	if (txt3.value == txt2.value) {
		sp3.style.visibility = "hidden"
		flag3 = true
	} else {
		sp3.innerHTML = "<p>两次输入的密码不相同</p>"
		sp3.style.visibility = "visible"
		flag3 = false
	}
}
function checkinput() {
	if (txt1.value == null || txt1.value == "" || txt2.value == null
			|| txt2.value == "" || txt3.value == null || txt3.value == ""
			|| txt4.value == null || txt4.value == "" || txt5.value == null
			|| txt5.value == "") {
		if (txt1.value == null || txt1.value == "") {
			sp1.innerHTML = "<p>该项没有填写</p>"
			sp1.style.visibility = "visible"
		}
		if (txt2.value == null || txt2.value == "") {
			sp2.innerHTML = "<p>该项没有填写</p>"
			sp2.style.visibility = "visible"
		}
		if (txt3.value == null || txt3.value == "") {
			sp3.innerHTML = "<p>该项没有填写</p>"
			sp3.style.visibility = "visible"
		}
		if (txt4.value == null || txt4.value == "") {
			sp4.innerHTML = "<p>该项没有填写</p>"
			sp4.style.visibility = "visible"
		}
		if (txt5.value == null || txt5.value == "") {
			sp5.innerHTML = "<p>该项没有填写</p>"
			sp5.style.visibility = "visible"
		}
		flag4 = false
	} else {
		flag4=true
	}
	if (rg1.test(txt1.value) || txt1.value != null || txt1.value != "") {
		flag1 = true
	} else {
		sp1.innerHTML = "<p>格式错误</p>"
		sp1.style.visibility = "visible"
		flag1 = false
	}
	if (rg2.test(txt2.value) || txt2.value == null || txt2.value == "") {
		flag2 = true
		if (txt2.value == txt3.value) {
			sp3.style.visibility = "hidden"
			flag3 = true
		}
	} else {
		sp2.innerHTML = "<p>格式错误</p>"
		sp2.style.visibility = "visible"
	}
	if (txt3.value == txt2.value) {
		flag3 = true
	} else {
		sp3.innerHTML = "<p>两次输入的密码不相同</p>"
		sp3.style.visibility = "visible"
		flag3 = false
	}
}
form.onsubmit=function(){
	checkinput()
	return flag1 && flag2 && flag3 && flag4 && checkbtn.checked==true
}