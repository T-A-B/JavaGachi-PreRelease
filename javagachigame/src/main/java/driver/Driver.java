package driver;

import controller.impl.JavaGachiMainScreenController;
import game.handlers.GameHandlerImpl;
import view.impl.JavaGachiMainScreenViewImpl;

public class Driver {
   /* static void doStuff() {
        FriendListController controller = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();
        JavaGachiFriendListModel flm = new JavaGachiFriendListModel();
        JavaGachiAgeImpl age = new JavaGachiAgeImpl();
        age.setSecondsOld(5000);
        flm.getJavaGachiList().add(new NonPlayerJavaGachiImpl("FRIEND ONE",age , Color.BLUE, Color.GREEN));
        controller.setModel(flm);
        controller.setView(view);
        controller.bind(controller.getView(), controller.getModel());
        controller.initialize();
        System.out.println("a");
    }*/

    public static void main(String[] args){

       // doStuff();




        JavaGachiMainScreenViewImpl view = new JavaGachiMainScreenViewImpl();

        JavaGachiMainScreenController controller = new JavaGachiMainScreenController();

        controller.setView(view);



        GameHandlerImpl gh = new GameHandlerImpl(controller);



        gh. playGame();


    }
}
