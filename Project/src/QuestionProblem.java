/**
 * Create with IntelliJ IDEA.
 * Description:
 * User: SDTBU_LY
 * Date: 2022-12-11
 * Time: 19:35
 */
public class QuestionProblem {
    private int Id;
    private String Description;
    private String Answer;

    QuestionProblem(){}
    QuestionProblem(int Id,String Description,String Answer){
        this.Id=Id;this.Description=Description;this.Answer = Answer;
    }
    void setId(int Id){
        this.Id = Id;
    }
    void setDescription(String Description){
        this.Description = Description;
    }
    void setAnswer(String Answer){
        this.Answer = Answer;
    }
    int getId(){
        return Id;
    }
    String getDescription(){
        return Description;
    }
    String getAnswer(){
        return Answer;
    }
}
