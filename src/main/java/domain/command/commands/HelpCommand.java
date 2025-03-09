package domain.command.commands;

import domain.command.Command;
import domain.command.Receiver;

public class HelpCommand implements Command {
    Receiver receiver = Receiver.getReceiver();

    @Override
    public void execute() {
        receiver.help();
    }

}



//public class Meow{
//    String cat;
//
//    public Meow(String cat){
//        this.cat = cat;
//    }
//
//    public String getCat() {
//        return cat;
//    }
//
//    public static void meow(){
//        System.out.println(cat + " say " + meeeeeow);
//    }
//}
//

