//Denna klass skapar Answer-objekt med parametrarna: text (svarsalternativ), och en boolean som är true om svaret är sant.
//Observera att klassen endast hanterar svar. Ett dilemma har flera Answer-objekt.
public class Answer {
    private boolean isCorrect;
    private String textAnswerPption;

    public Answer(String text, boolean isCorrect) {
        this.isCorrect = isCorrect;
        this.textAnswerPption = text;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }

    public String getText() {
        return this.textAnswerPption;
    }
}
