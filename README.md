# Zed-Trivia App
###### _Class Assignment - Creating a quiz game_
## Overview
This project is a Quiz Game application developed using Java's Swing library. The game presents users with a series of questions and provides multiple-choice answers. Users select an answer, and the application gives feedback on whether the answer was correct or incorrect. The game keeps track of the user's score throughout the session.

## Features

- Multiple-choice questions
- Score tracking
- Feedback on correct/incorrect answers
- Simple and intuitive graphical user interface (GUI)
- Developed using Java Swing for GUI components

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA (or any other preferred Java IDE)

## Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/POLLARD1145/Zed-Trivia.git
cd Zed-Trivia
```

### 2. Open the Project in IntelliJ

1. Launch IntelliJ IDEA.
2. Click on `File` -> `Open`.
3. Navigate to the cloned repository directory and select it.
4. Click `OK` to open the project.

### 3. Run the Application

1. Open the `Main.java` file located in the `src` directory.
2. Click the `Run` button or right-click and select `Run 'Main.main()'`.

## Project Structure

```
quiz-game/
│
│── out/
│       └── production/
│           └── zed_trivia/
│               └── Main.java
│               └── HomeWindow.java
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── quizgame/
│   │   │   │   │   ├── Main.java
│   │   │   │   │   ├── HomeWindow.java
│   │   │   │   │   ├── Question.java
│   │   │   │   │   ├── QuestionBank.java
│   │   │   │   │   └── ResultFrame.java
│   │   └── resources/
│── zed_trivia.iml
└── README.md
└── .gitignore
```

### Main Components

- **Main.java**: The entry point of the application.
- **HomeWindow.java**: The main GUI frame that displays the quiz questions and handles user interactions.
- **Question.java**: A class representing a single quiz question.
- **QuestionBank.java**: A class that holds a collection of questions for the quiz.
- **ResultFrame.java**: A frame that displays the user's score and final results.
- **Answers.java**: A frame showing the answers that are correct for each question in the quiz
## Usage

1. Run the application as described in the "Run the Application" section.
2. The quiz game window will open, displaying the first question and multiple-choice answers.
3. Select an answer and click the "Next" button.
4. The application will provide feedback and move to the next question.
5. After answering all the questions, the application will display the final score.

## Customization

### Adding New Questions

1. Open the `QuestionBank.java` file.
2. Add new `Question` objects to the question list.

```java
questions.add(new Question("What is the capital of Zambia?", new String[]{"Paris", "Lusaka", "Berlin", "Madrid"}, 1));
questions.add(new Question("Who is the first President of Zambia'?", new String[]{"William Shakespeare", "Charles Dickens", "Kenneth Kaunda", "Jane Austen"}, 2));
```

### Modifying the GUI

1. Open the `QuizFrame.java` file.
2. Modify the layout and components as needed using Java Swing.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgements

- Java Swing documentation
- IntelliJ IDEA
- Dr. Maybin Lengwe - CBU Lecturer

## Contact

For any questions or suggestions, please contact [pollardsamba1@gmail.com](mailto:pollardsamba1@gmail.com).

---

Happy coding!