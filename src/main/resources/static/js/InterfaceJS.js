"use strict";

let user = {
  ID: 1,
};

const btnSumbitSingIn = document.getElementById("btn-signin");

btnSumbitSingIn.addEventListener("click", async function (e) {
  e.preventDefault();

  try {
    const postRequest = await axios
      .create({
        headers: {
          "Content-Type": "application/json",
          "ngrok-skip-browser-warning": "true",
        },
      })
      .post("http://localhost:8080/login", {
        email: "aa@mail.com",
        password: "12f3",
      });
    console.log(postRequest);
    if (postRequest.status == 200) {
      window.location.assign(
        `http://127.0.0.1:5500/Project/homePage.html?userID=${postRequest.data.id}`
      );
    } else {
      alert("something went wrong");
    }
  } catch (error) {
    alert("password or username is invail");
  }
});
function toggleForms() {
  let signinContainer = document.getElementById("signin-form-container");
  let signupContainer = document.getElementById("signup-form-container");
  if (signinContainer.style.display === "none") {
    signinContainer.style.display = "block";
    signupContainer.style.display = "none";
  } else {
    signinContainer.style.display = "none";
    signupContainer.style.display = "block";
  }
}

function checkRole() {
  let role = document.getElementById("userRole").value;
  let genderSelection = document.getElementById("genderSelection");
  if (role === "student") {
    genderSelection.style.display = "block";
  } else {
    genderSelection.style.display = "none";
  }
}
