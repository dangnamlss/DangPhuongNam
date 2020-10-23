package sample;

public class Word {
    private String word_target, word_explain, word_type, word_pronun;

    public Word(){}

    public Word(String word_target, String word_type, String word_pronun, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_type = word_type;
        this.word_pronun = word_pronun;

    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }

    public void setWord_pronun(String word_pronun) {
        this.word_pronun = word_pronun;
    }



    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_type() {
        return word_type;
    }

    public String getWord_pronun() {
        return word_pronun;
    }


}
