package BusReservation_System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BusReservationSystem {
    protected Connection con;
    private JFrame frame;
    private JTextField nameField, phoneField, emailField, ageField,
            addressField, idProofTypeField, idProofNumberField, seatNumberField;
    private JLabel lName, lPhone, lEmail, lAge, lGender, lAddress, lIdtype, lIdnumber, lBusnumber, lSeatnumber, limg;
    private JComboBox<String> busBox;
    private JRadioButton radioMale, radioFemale, radioOther,radioAadhar,radioPan,radioDriving,radioOther1;
    private ButtonGroup genderGroup,idProofGroup;
    private ImageIcon icon;
    private JButton bookButton, cancelButton, checkAvailabilityButton, invoiceButton, newButton,paymentButton;
    private JTextArea availabilityTextArea ,reservationInfo,invoiceDetails;

    public BusReservationSystem() {
        connectDB();
        buildUI();
    }

    private void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservationDB", "your_username", "your_password");
            System.out.println("Database connected successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Something went wrong.Drivers loading failed");
        } catch (SQLException e) {
            System.out.println("Something went wrong. Database Connection Failed!");
            ;
        }
    }

    //Building the UI
    private void buildUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        frame = new JFrame("Bus Ticket Reservation System");
        frame.setSize(screenWidth, screenHeight);
        frame.getContentPane().setBackground(Color.decode("#cce4ed"));
        frame.setLayout(null);

        lName = new JLabel("Name:");
        //lName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lName.setBounds(30, 30, 100, 40);
        frame.add(lName);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 325, 40);
        nameField.setBackground(Color.decode("#cce4ed"));
        nameField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(nameField);

        lPhone = new JLabel("Phone Number:");
        //lPhone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lPhone.setBounds(30, 90, 100, 40);
        frame.add(lPhone);

        phoneField = new JTextField();
        phoneField.setBounds(150, 90, 325, 40);
        phoneField.setBackground(Color.decode("#cce4ed"));
        phoneField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(phoneField);

        lAge = new JLabel("Age:");
        //lAge.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lAge.setBounds(30, 150, 100, 40);
        frame.add(lAge);

        ageField = new JTextField();
        ageField.setBounds(150, 150, 325, 40);
        ageField.setBackground(Color.decode("#cce4ed"));
        ageField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(ageField);

        lGender = new JLabel("Gender:");
        lGender.setBounds(30, 210, 100, 40);
        frame.add(lGender);

        radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(150, 210, 140, 20);
        radioFemale.setBackground(Color.decode("#cce4ed"));

        radioMale = new JRadioButton("Male");
        radioMale.setBounds(300, 210, 140, 20);
        radioMale.setBackground(Color.decode("#cce4ed"));

        radioOther = new JRadioButton("Other");
        radioOther.setBounds(150, 240, 140, 20);
        radioOther.setBackground(Color.decode("#cce4ed"));

        genderGroup = new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);
        genderGroup.add(radioOther);

        frame.add(radioFemale);
        frame.add(radioMale);
        frame.add(radioOther);

        lEmail = new JLabel("Email:");
        //lEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lEmail.setBounds(30, 280, 100, 40);
        frame.add(lEmail);

        emailField = new JTextField();
        emailField.setBounds(150, 280, 325, 40);
        emailField.setBackground(Color.decode("#cce4ed"));
        emailField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(emailField);

        lAddress = new JLabel("Address:");
        //lAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lAddress.setBounds(30, 340, 100, 30);
        frame.add(lAddress);

        addressField = new JTextField();
        addressField.setBounds(150, 340, 325, 40);
        addressField.setBackground(Color.decode("#cce4ed"));
        addressField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(addressField);

        lIdtype = new JLabel("ID Proof Type:");
        //lIdtype.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lIdtype.setBounds(30, 400, 100, 40);
        frame.add(lIdtype);

        radioAadhar = new JRadioButton("Aadhar Card");
        radioAadhar.setBounds(150, 400, 140, 20);
        radioAadhar.setBackground(Color.decode("#cce4ed"));

        radioPan = new JRadioButton("PAN Card");
        radioPan.setBounds(300, 400, 140, 20);
        radioPan.setBackground(Color.decode("#cce4ed"));

        radioDriving = new JRadioButton("Driving License");
        radioDriving.setBounds(150, 430, 140, 20);
        radioDriving.setBackground(Color.decode("#cce4ed"));

        radioOther1 = new JRadioButton("Other");
        radioOther1.setBounds(300, 430, 140, 20);
        radioOther1.setBackground(Color.decode("#cce4ed"));

        idProofGroup = new ButtonGroup();
        idProofGroup.add(radioAadhar);
        idProofGroup.add(radioPan);
        idProofGroup.add(radioDriving);
        idProofGroup.add(radioOther1);

        frame.add(radioAadhar);
        frame.add(radioPan);
        frame.add(radioDriving);
        frame.add(radioOther1);

        lIdnumber = new JLabel("ID Proof No.:");
        //lIdnumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lIdnumber.setBounds(30, 460, 100, 40);
        frame.add(lIdnumber);

        idProofNumberField = new JTextField();
        idProofNumberField.setBounds(150, 460, 325, 40);
        idProofNumberField.setBackground(Color.decode("#cce4ed"));
        idProofNumberField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(idProofNumberField);

        lBusnumber = new JLabel("BusNumber:");
        //lBusnumber.setFont(new Font("Serif", Font.BOLD, 14));
        lBusnumber.setBounds(30, 520, 100, 40);
        frame.add(lBusnumber);

        busBox = new JComboBox<>(busList());
        busBox.setBounds(150, 520, 325, 40);
        busBox.setBackground(Color.decode("#afcfdb"));
        busBox.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c")));
        busBox.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(busBox);
        //busBox.setPreferredSize(new Dimension(100, 20));

        lSeatnumber = new JLabel("SeatNumber:");
        //lSeatnumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lSeatnumber.setBounds(30, 580, 100, 40);
        frame.add(lSeatnumber);

        seatNumberField = new JTextField();
        seatNumberField.setBounds(150, 580, 325, 40);
        seatNumberField.setBackground(Color.decode("#cce4ed"));
        seatNumberField.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(seatNumberField);

        cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(500, 70, 200, 70);
        cancelButton.setBackground(Color.decode("#8abed4"));
        cancelButton.addActionListener(e -> cancelTicket());
        frame.add(cancelButton);

        checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.setBounds(500, 160, 200, 70);
        checkAvailabilityButton.setBackground(Color.decode("#8abed4"));
        checkAvailabilityButton.addActionListener(e -> checkAvailability());
        frame.add(checkAvailabilityButton);

        availabilityTextArea = new JTextArea();
        availabilityTextArea.setBounds(720, 160, 500, 70);  // Positioned beside the button
        availabilityTextArea.setEditable(false);
        availabilityTextArea.setBackground(Color.decode("#e0f7fa"));
        availabilityTextArea.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
        frame.add(availabilityTextArea);


        invoiceButton = new JButton("Print Invoice");
        invoiceButton.setBounds(500, 250, 200, 70);
        invoiceButton.setBackground(Color.decode("#8abed4"));
        invoiceButton.addActionListener(e -> printInvoive());
        frame.add(invoiceButton);

        ImageIcon icon = new ImageIcon("C:/Users/shrad/Downloads/busImg1.jpg");
        Image img = icon.getImage().getScaledInstance(200, 210, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(500, 260, 200, 350);
        frame.add(imageLabel);

        bookButton = new JButton("Book Ticket");
        bookButton.setBounds(500, 550, 200, 70);
        bookButton.setBackground(Color.decode("#8abed4"));
        bookButton.addActionListener(e -> bookTicket());
        frame.add(bookButton);

        newButton = new JButton("Hey! Want to do new Reservation?");
        newButton.setBounds(820, 50, 300, 80);
        newButton.setBackground(Color.decode("#8abed4"));
        newButton.addActionListener(e -> {
            // Clear all text fields and text areas
            for (Component comp : frame.getContentPane().getComponents()) {
                if (comp instanceof JTextField) {
                    ((JTextField) comp).setText(""); // Clear text field
                } else if (comp instanceof JTextArea) {
                    ((JTextArea) comp).setText(""); // Clear text area
                }
            }
            invoiceDetails.setVisible(false);
            // Show confirmation message
            JOptionPane.showMessageDialog(frame, "Now! Book your new Reservation.");
        });
        frame.add(newButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //Retriving the Bus List
    private String[] busList() {
        try {
            PreparedStatement ps = con.prepareStatement("select BusNumber from Buses");
            ResultSet rs = ps.executeQuery();
            java.util.List<String> bus = new java.util.ArrayList<>();
            while (rs.next()) {
                String busNo = rs.getString("BusNumber");
                bus.add(busNo);
            }
            // System.out.println("Bus List successfully");
            return bus.toArray(new String[0]);

        } catch (SQLException e) {
            e.printStackTrace();
            return new String[]{"No Buses Available"};
        }
    }
    //Ticket Booking
    private void bookTicket() {
        try {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String age = ageField.getText();
            String gender = radioMale.isSelected() ? "Male" : radioFemale.isSelected() ? "Female" : "Other";
            String address = addressField.getText();
            String idProofType = radioAadhar.isSelected() ? "Aadhar Card" : radioPan.isSelected() ? "PAN Card" : radioDriving.isSelected() ? "Driving License" : "Other";
            String idProofNumber = idProofNumberField.getText();
            String busNumber = (String) busBox.getSelectedItem();
            int seatNumber = Integer.parseInt(seatNumberField.getText());

            PreparedStatement psfetchbusID = con.prepareStatement("select ID from Buses where BusNumber = ?");
            psfetchbusID.setString(1, busNumber);
            ResultSet rsfetchbusID = psfetchbusID.executeQuery();
            int busID = 0;
            if (rsfetchbusID.next()) {
                busID = Integer.parseInt(rsfetchbusID.getString("ID"));
            }

            PreparedStatement pscheckSeat = con.prepareStatement("select count(*) from Reservations where BusID =? and SeatNo = ?");
            pscheckSeat.setInt(1, busID);
            pscheckSeat.setInt(2, seatNumber);
            ResultSet rscheckSeat = pscheckSeat.executeQuery();
            if (rscheckSeat.next() && rscheckSeat.getInt(1) > 0) {
                JOptionPane.showMessageDialog(frame, "Seat has already booked!");
                return;
            }

            if(seatNumber>40){
                JOptionPane.showMessageDialog(frame, "Invalid Seat Number. There are 40 seats available!");
                return;
            }

            PreparedStatement psPassenger = con.prepareStatement(
                    "insert ignore into Passengers (Passenger_Name, Age, Gender, Phone_No, Email_Address, Address, Identity_Proof_Type, Identity_Proof_No) values(?, ?, ?, ?, ?, ?, ?, ?)");
            psPassenger.setString(1, name);
            psPassenger.setString(2, age);
            psPassenger.setString(3, gender);
            psPassenger.setString(4, phone);
            psPassenger.setString(5, email);
            psPassenger.setString(6, address);
            psPassenger.setString(7, idProofType);
            psPassenger.setString(8, idProofNumber);
            psPassenger.executeUpdate();

            PreparedStatement psGetPassenger = con.prepareStatement("select ID from Passengers where Phone_No = ?");
            psGetPassenger.setString(1, phone);
            ResultSet rsPassenger = psGetPassenger.executeQuery();
            int passengerId = rsPassenger.next() ? rsPassenger.getInt("ID") : 0;

            if (passengerId == 0) {
                throw new SQLException("Passenger not found or not inserted correctly.");
            }

            PreparedStatement psGetBus = con.prepareStatement("select ID, Available_seats,Journey_Date from Buses where BusNumber = ?");
            psGetBus.setString(1, busNumber);
            ResultSet rsBus = psGetBus.executeQuery();

            if (rsBus.next() && rsBus.getInt("Available_seats") > 0) {
                int busId = rsBus.getInt("ID");
                PreparedStatement psBooking = con.prepareStatement("insert into Reservations (PassengerID, BusID, SeatNo) values(?, ?, ?)");
                psBooking.setInt(1, passengerId);
                psBooking.setInt(2, busId);
                psBooking.setInt(3, seatNumber);
                psBooking.executeUpdate();

                PreparedStatement psUpdateSeats = con.prepareStatement("update Buses set Available_seats = Available_seats - 1 where ID = ?");
                psUpdateSeats.setInt(1, busId);
                psUpdateSeats.executeUpdate();

                //above insert query executes successfully

                PreparedStatement psRetrieve = con.prepareStatement("select R.ID, B.BusNumber,B.Departure,B.Destination,B.Journey_Date, R.SeatNo, P.Passenger_Name,\n" +
                        "P.Phone_No, P.Email_Address, B.Driver_name, B.Driver_contact, B.Fare\n" +
                        "from Reservations R\n" +
                        "join Buses B on R.BusID = B.ID\n" +
                        "join Passengers P on R.PassengerID = P.ID\n" +
                        "where R.PassengerID = ? order by R.ID desc limit 1");
                psRetrieve.setInt(1, passengerId);
                ResultSet rsRetrieve = psRetrieve.executeQuery();

                if (rsRetrieve.next()) {
                    String reservationDetails = "Reservation ID: " + rsRetrieve.getInt("ID") + "\n" +"\n" +
                            "Bus Number: " + rsRetrieve.getString("BusNumber") + "\n" +"\n" +
                            "Seat Number: " + rsRetrieve.getInt("SeatNo") + "\n" +"\n" +
                            "Passenger Name: " + rsRetrieve.getString("Passenger_Name") + "\n" +"\n" +
                            "Phone: " + rsRetrieve.getString("Phone_No") + "\n" +"\n" +
                            "Email: " + rsRetrieve.getString("Email_Address") + "\n" +"\n" +
                            "Driver Name: " + rsRetrieve.getString("Driver_name") + "\n" +"\n" +
                            "Driver Phone: " + rsRetrieve.getString("Driver_contact")+ "\n" +"\n" +
                            "Payment Amount:"+rsRetrieve.getDouble("Fare");
                    reservationInfo = new JTextArea(reservationDetails);
                    reservationInfo.setBounds(820, 250, 300, 280);
                    reservationInfo.setEditable(false);
                    reservationInfo.setBackground(Color.decode("#e0f7fa"));
                    reservationInfo.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
                    frame.add(reservationInfo);
                    reservationInfo.setVisible(true);

                    paymentButton = new JButton("Proceed to Payment");
                    paymentButton.setBounds(870, 550, 200, 70);
                    paymentButton.setBackground(Color.decode("#8abed4"));
                    paymentButton.addActionListener(e ->{
                        try{
                            PreparedStatement psGetReservation = con.prepareStatement("select ID from Reservations where PassengerID = ? order by ID desc limit 1");
                            psGetReservation.setInt(1, passengerId);
                            ResultSet rs = psGetReservation.executeQuery();

                            int reservationId = -1;
                            if (rs.next()) {
                                reservationId = rs.getInt("ID");
                            } else {
                                JOptionPane.showMessageDialog(frame, "No reservation found!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            PreparedStatement psFare = con.prepareStatement("Select Fare from Buses where ID = ?");
                            psFare.setInt(1, busId);
                            ResultSet rsFare = psFare.executeQuery();
                            double fare=0;
                            if (rsFare.next()) {
                                fare = rsFare.getDouble("Fare");
                            }
                            PreparedStatement psPayment = con.prepareStatement("insert into Payments(PassengerID,ReservationID,Amount,status)values(?,?,?,?)");
                            psPayment.setInt(1, passengerId);
                            psPayment.setInt(2, reservationId);
                            psPayment.setDouble(3,fare);
                            //String paid = "Paid";"
                            psPayment.setString(4, "Success");
                            psPayment.executeUpdate();

                            String updateQuery = "update Reservations set Payment_status = 'Paid' where ID = ?";
                            PreparedStatement psUpdate = con.prepareStatement(updateQuery);
                            psUpdate.setInt(1, reservationId);
                            psUpdate.executeUpdate();

                            JOptionPane.showMessageDialog(frame, "Payment Successful! Ticket booked successfully.");

                        }catch(SQLException se){
                            se.printStackTrace();
                            JOptionPane.showMessageDialog(frame, "Error processing payment!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                    frame.add(paymentButton);
                    paymentButton.setVisible(true);

                    frame.repaint();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No available seats!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Something went wrong! Unable to book ticket.");
        }
    }



    //Ticket Cancellation
    private void cancelTicket() {
        try {
            String phone = phoneField.getText();
            String busNumber = (String) busBox.getSelectedItem();

            PreparedStatement psGetPassenger = con.prepareStatement("select ID from Passengers where Phone_No = ?");
            psGetPassenger.setString(1, phone);
            ResultSet rsPassenger = psGetPassenger.executeQuery();

            if (rsPassenger.next()) {
                int passengerId = rsPassenger.getInt("ID");

                PreparedStatement psGetBus = con.prepareStatement("select ID from Buses where BusNumber = ?");
                psGetBus.setString(1, busNumber);
                ResultSet rsBus = psGetBus.executeQuery();

                if (rsBus.next()) {
                    int busId = rsBus.getInt("id");
                    PreparedStatement psCancel = con.prepareStatement("update Reservations set Reservation_status = 'Cancelled',Payment_status ='Refunded',SeatNo=0 where PassengerID = ? and BusID = ?");
                    psCancel.setInt(1, passengerId);
                    psCancel.setInt(2, busId);
                    int rows = psCancel.executeUpdate();

                    if (rows > 0) {
                        PreparedStatement psUpdateSeats = con.prepareStatement(
                                "update Buses set Available_seats = Available_seats + 1 where ID = ?");
                        psUpdateSeats.setInt(1, busId);
                        psUpdateSeats.executeUpdate();
                        JOptionPane.showMessageDialog(frame, "Ticket cancelled successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "No booking found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went Wrong! Unable to Cancel Ticket.");
        }
    }

    //Checking Available Seats
    private void checkAvailability() {
        try {
            String busNumber = (String) busBox.getSelectedItem();

            if (busNumber == null || busNumber.trim().isEmpty()) {
                availabilityTextArea.setText("Please select a valid bus number.");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                    "select BusNumber, Departure, Destination, Available_seats,Journey_Date,Departure_time, Arrival_time from Buses where BusNumber = ?"
            );
            ps.setString(1, busNumber);
            ResultSet rs = ps.executeQuery();

            StringBuilder busData = new StringBuilder();
            busData.append("Bus No | Departure -> Destination | Available Seats | Journey Date | Departure Time | Arrival Time\n");
            busData.append("-----------------------------------------------------------------------------------------------------------------------\n");

            boolean found = false;
            while (rs.next()) {
                found = true;
                String busNo = rs.getString("BusNumber");
                String departure = rs.getString("Departure");
                String destination = rs.getString("Destination");
                int availableSeats = rs.getInt("Available_seats");
                String journeyDate = rs.getString("Journey_Date");
                String departureTime = rs.getString("Departure_time");
                String arrivalTime = rs.getString("Arrival_time");

                busData.append(busNo)
                        .append(" | ")
                        .append(departure).append(" -> ").append(destination)
                        .append(" | ").append(availableSeats)
                        .append(" | ").append(journeyDate)
                        .append(" | ").append(departureTime)
                        .append(" | ").append(arrivalTime)
                        .append("\n");
            }

            if (!found) {
                busData.append("No available data for the selected bus.");
            }

            availabilityTextArea.setText(busData.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            availabilityTextArea.setText("Error fetching data!");
        }
    }

    //printing invoice
    public void printInvoive() {
        try {
            String phone = phoneField.getText();
            PreparedStatement psGetPassenger = con.prepareStatement("select ID from Passengers where Phone_No = ?");
            psGetPassenger.setString(1, phone);
            ResultSet rsPassenger = psGetPassenger.executeQuery();
            int passengerId = rsPassenger.next() ? rsPassenger.getInt("ID") : 0;
            PreparedStatement psRetrieve = con.prepareStatement("select R.ID, B.BusNumber,B.Departure,B.Destination,B.Journey_Date, R.SeatNo, P.Passenger_Name,\n" +
                    "P.Phone_No, P.Email_Address, B.Driver_name, B.Driver_contact,Py.ID,Py.Amount,Py.payment_date\n" +
                    "from Reservations R\n" +
                    "join Buses B on R.BusID = B.ID\n" +
                    "join Passengers P on R.PassengerID = P.ID\n" +
                    "join Payments Py on R.ID = Py.ReservationID\n" +
                    "where R.PassengerID = ? order by R.ID desc limit 1");
            psRetrieve.setInt(1, passengerId);
            ResultSet rsRetrieve = psRetrieve.executeQuery();

            if (rsRetrieve.next()) {
                String reservationDetails = "INVOICE" +"\n" +
                        "---------------------------------------------------------------------------------------------"+"\n" +
                        "Reservation ID: " + rsRetrieve.getInt("ID") + "\n" +"\n" +
                        "Bus Number: " + rsRetrieve.getString("BusNumber") + "\n" +"\n" +
                        "Seat Number: " + rsRetrieve.getInt("SeatNo") + "\n" +"\n" +
                        "Passenger Name: " + rsRetrieve.getString("Passenger_Name") + "\n" +"\n" +
                        "Phone: " + rsRetrieve.getString("Phone_No") + "\n" +"\n" +
                        "Email: " + rsRetrieve.getString("Email_Address") + "\n" +"\n" +
                        "Driver Name: " + rsRetrieve.getString("Driver_name") + "\n" +"\n" +
                        "Driver Phone: " + rsRetrieve.getString("Driver_contact")+"\n" +"\n" +
                        "Payment ID:"+rsRetrieve.getInt("ID")+"\n" +"\n" +
                                "Payment Amount:"+rsRetrieve.getDouble("Amount")+"\n" +"\n" +
                                "Payment Date:"+rsRetrieve.getString("payment_date");
                invoiceDetails = new JTextArea(reservationDetails);
                invoiceDetails.setBounds(820, 250, 300, 370);
                invoiceDetails.setEditable(false);
                invoiceDetails.setBackground(Color.decode("#e0f7fa"));
                invoiceDetails.setBorder(BorderFactory.createLineBorder(Color.decode("#6b8e9c"), 2));
                frame.add(invoiceDetails);
                invoiceDetails.setVisible(true);
                frame.repaint();
                paymentButton.setVisible(false);
                reservationInfo.setVisible(false);
            }
        }catch(SQLException sq){
            sq.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error fetching data!");
        }
    }

    //main method
    public static void main(String[] args) {

        new BusReservationSystem();
    }
}