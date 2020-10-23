public class Word {
    String word_target;

    String word_explain;

    Word (String _target, String _explain) {
        this.word_target = _target;
        this.word_explain = _explain;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }
}
