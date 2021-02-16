public class Main {
    public static void main(String[] args){
    //Here we initialize the mainController and runs it.
    MainController mc = new MainController();
        try {
            mc.runProgram();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        } catch (InvalidAmountException e) {
            e.printStackTrace();
        }
    }
}
