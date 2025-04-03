🚍 Bus Reservation System -
A Java-based Bus Reservation System with a Swing-based UI and MySQL database integration using JDBC.   

📌 Features:
✔ Book a Ticket – Select a bus, enter passenger details, and confirm the reservation.
✔ Cancel Ticket – Updates reservation status to Cancelled, refunds payment, and resets the seat.
✔ Check Availability – Displays the number of available seats (not seat numbers) for the selected bus.
✔ Print Invoice – Generates a ticket invoice and hides unnecessary UI elements.
✔ New Reservation – Clears all input fields for a fresh booking session.                                                                       

1️⃣ Setup MySQL Database-
Execute the database creation queries in MySQL Workbench or any SQL terminal.
2️⃣ Configure JDBC Connection-
Update connectDB() with your MySQL username and password:
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservationdb", "your_username", "your_password");                                               
3️⃣ Run the Project-
Compatible with VS Code, IntelliJ IDEA, Sublime Text, Notepad, or JDK Terminal:
javac BusReservationSystem.java
java BusReservationSystem                                                                                                                                                   

🖱 Button Functionality:
Book Ticket 🚌 → Saves passenger details and assigns a seat if available.
Cancel Ticket ❌ → Cancels the reservation, marks seat as empty, and processes refund.
Check Availability ✅ → Displays the count of available seats for the selected bus.
Print Invoice 🖨 → Generates a booking invoice and hides unnecessary UI elements.
New Reservation 🔄 → Clears all input fields for a fresh booking session.
