"use strict";

// Samples Data

// Sample Reservations:
const reservations = [
  {
    place: "Lab",
    capacity: "10/20",
    startDate: "2024-05-01",
    endDate: "2024-05-05",
    status: "Available",
    gender: "Both",
  },
  {
    place: "Swimming Pool",
    capacity: "5/10",
    startDate: "2024-05-10",
    endDate: "2024-05-15",
    status: "Coming",
    gender: "Male",
  },
];

///////////////////////////
// Event Handlers

// Create Reservation Button:
const modal = document.getElementById("modal");
const closeBtn = document.querySelector(".close-btn");
const cancelBtn = document.querySelector(".cancel-btn");
const submitBtn = document.querySelector(".submit-btn");
const createReservationBtn = document.getElementById("create-button");

document
  .getElementById("modal-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
    const formData = new FormData(event.target);
    const newReservation = {
      place: formData.get("place"),
      capacity: formData.get("capacity"),
      startDate: formData.get("start-date"),
      endDate: formData.get("end-date"),
      status: "Available", // Default status
      gender: formData.get("gender"),
    };
    reservations.push(newReservation);
    displayReservations();
    console.log("New reservation added:", newReservation);
    console.log("Updated reservations:", reservations);
    modal.style.display = "none";
  });
createReservationBtn.addEventListener("click", (e) => {
  e.preventDefault();
  console.log("Button clicked"); // Add this line for debugging
  modal.style.display = "block";
});

closeBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

cancelBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

// Reservation Displaying
const displayReservations = function () {
  const reservationContainer = document.getElementById("reservation-container");

  // Clear previous content
  reservationContainer.innerHTML = "";

  // Iterate through reservations and create HTML elements for each reservation
  let row = null;
  reservations.forEach((reservation, index) => {
    if (index % 3 === 0) {
      // Start a new row after every three reservations
      row = document.createElement("div");
      row.classList.add("reservation-row");
      reservationContainer.appendChild(row);
    }

    const reservationDiv = document.createElement("div");
    reservationDiv.classList.add("reservation");

    reservationDiv.innerHTML = `
          <h3>${reservation.place}</h3>
          <p>Capacity: ${reservation.capacity}</p>
          <p>Start Date: ${reservation.startDate}</p>
          <p>End Date: ${reservation.endDate}</p>
          <p>Status: ${reservation.status}</p>
          <p>Gender: ${reservation.gender}</p>
      `;

    row.appendChild(reservationDiv);
  });
};

// Call the function to display reservations when the page loads
window.addEventListener("load", displayReservations);
