
window.onload = function() {
//	loadHomepageView();
	retrieveUserInfo();
	
}

//function loadHomepageView() {
//	let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			document.getElementById('view').innerHTML = xhr.responseText;
//			retrieveUserInfo(); //This function shouldn't work until I make a real servlet for it
//		}
//	}
//	xhr.open("GET", "dashboard", true);
//	xhr.send();
//}

function updateInfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()	{
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			let user = JSON.parse(xhr.responseText);
	console.log('updating info');
	var username = document.getElementById('e_username').value;
	var pass = document.getElementById('e_password').value;
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var email = document.getElementById('email').value;
	
	var user = {
			username : this.username,
			pass : this.pass,
			firstName : this.firstName,
			lastName : this.lastName,
			email : this.email			
	}
	user = Json.stringify(user); 
	
	console.log("User values: " + e_username + " " + e_password + " " + firstName + " " + lastName + " " + email);
		}
	}
	xhr.open("POST", "update", true) 
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(user);
		}

function logout() {
	console.log('logging out')
	document.getElementById('e_username').value = '';
	document.getElementById('e_password').value = '';
	document.getElementById('firstName').value = '';
	document.getElementById('lastName').value = '';
	document.getElementById('email').value = '';
	console.log("User values: " + e_username + " " + e_password + " " + firstName + " " + lastName + " " + email);
}

function retrieveUserInfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()	{
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			let userDTO = JSON.parse(xhr.responseText);
			
			document.getElementById('id').innerHTML += userDTO.id;
			document.getElementById('username').innerHTML += userDTO.username;			
			document.getElementById('firstname').innerHTML += userDTO.firstname;
			document.getElementById('lastname').innerHTML += userDTO.lastname;
			document.getElementById('email').innerHTML += userDTO.email;
			
		}
	}
	xhr.open("GET", "accountInfo", true) 
	xhr.send(); // Continue from here. Use app.js for reference. Lines 66-78
	// used above
}

function loadAccountInfo(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState = 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let userDTO = JSON.parse(xhr.responseText);
		document.getElementById('username').innerHTML = userDTO.username;
		//document.getElementById('view').innerHTML = xhr.responseText;				
	}
}
	xhr.open('GET', "accountInfo", true);
	xhr.send();
	
}