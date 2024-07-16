public class Question {

    private String category;
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String category, String question, String[] options, String correctAnswer) {
        this.category = category;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }
    public String getAnswer() {
        return this.correctAnswer;
    }


    @Override
    public String toString() {
        return "Category: " + category + "\nQuestion: " + question + "\nOptions: " + String.join(", ", options) + "\nCorrect Answer: " + correctAnswer;
    }
}

