🏏 Live Cricket Score App


📌 Overview

The Live Cricket Score App is a Java-based console application that fetches live cricket scores using the CricBuzz API. It utilizes Java Networking (java.net), XML Parsing (JAXP), and OOP principles to provide real-time match details.

✨ Features

✅ Fetch live cricket scores from CricBuzz API✅ View ongoing, upcoming, and completed matches✅ Display match details including teams, scores, and player stats✅ Demonstrates inheritance and polymorphism in Java✅ Simple console-based user interface

📂 Project Structure

Live Cricket Score App/
│── src/
│   ├── cricket/
│   │   ├── App.java        # Main entry point
│   │   ├── CricBuzz.java   # Handles API calls
│   │   ├── Constants.java  # Stores constants
│   │   ├── model/
│   │   │   ├── match/
│   │   │   │   ├── Match.java
│   │   │   │   ├── LiveMatch.java
│   │   │   │   ├── CompletedMatch.java
│   │   │   │   ├── UpcomingMatch.java
│   │   │   ├── player/
│   │   │   │   ├── Player.java
│   │   │   │   ├── Batsman.java
│   │   │   │   ├── Bowler.java
│   │   │   ├── team/
│   │   │   │   ├── Team.java
│   │   │   │   ├── Inning.java
│── bin/    # Compiled class files
│── README.md


🚀 Installation & Setup

1️⃣ Prerequisites

Java JDK 17+ (Download here)

VS Code or any Java IDE

Internet connection (for API access)

2️⃣ Clone the Repository

git clone https://github.com/ayushgautam0704/live-cricket-score-app.git
cd live-cricket-score-app

3️⃣ Compile & Run the Application

javac -d bin -sourcepath src src/cricket/App.java
java -cp bin cricket.App

📖 Usage

Run the application

Select an option from the menu:

1 - Get live matches summary

2 - Enter a match ID to view its details

View real-time match details on the console!

🛠 Technologies Used

Java (java.net, JAXP) - Networking & XML Parsing

OOP Principles - Inheritance, Polymorphism

CricBuzz API - Live cricket data

🤝 Contributing

Pull requests are welcome! To contribute:

Fork the repository 🍴

Create a new branch (git checkout -b feature-branch)

Commit your changes (git commit -m 'Add new feature')

Push to the branch (git push origin feature-branch)

Open a Pull Request 🚀

📧 Contact

Have questions? Reach out via:
📩 Email: ayushgautamsh07@gmail.com🐦 Twitter: @ayushgautam0704

🌟 Star the repo if you like this project! ⭐

