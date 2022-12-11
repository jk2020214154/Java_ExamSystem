/**
 * Create with IntelliJ IDEA.
 * Description:
 * User: SDTBU_LY
 * Date: 2022-12-11
 * Time: 19:18
 */
public class SelectProblem {
    private int Id;
    private String Description;
    private String Select_A;
    private String Select_B;
    private String Select_C;
    private String Select_D;
    private String Answer;

    SelectProblem(){}
    SelectProblem(int Id,String Description,String Select_A,String Select_B,String Select_C,String Select_D,String Answer){
        this.Id = Id;this.Description=Description;
        this.Select_A=Select_A;this.Select_B = Select_B;this.Select_C = Select_C;this.Select_D = Select_D;this.Answer = Answer;
    }
    void setId(int Id){
        this.Id = Id;
    }
    void setDescription(String Description){
        this.Description = Description;
    }
    void setSelect_A(String Select_A){
        this.Select_A = Select_A;
    }
    void setSelect_B(String Select_B) {
        this.Select_B = Select_B;
    }
    void setSelect_C(String Select_C) {
        this.Select_C = Select_C;
    }
    void setSelect_D(String Select_D){
        this.Select_D = Select_D;
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
    String getSelect_A(){
        return Select_A;
    }
    String getSelect_B() {
        return Select_B;
    }
    String getSelect_C(){
        return Select_C;
    }
    String getSelect_D() {
        return Select_D;
    }
    String getAnswer(){
        return Answer;
    }
}
