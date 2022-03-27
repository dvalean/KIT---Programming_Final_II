package edu.kit.informatik;

import edu.kit.informatik.ui.Session;

public final class Application {

    private Application() {

    }

    public static void main(String[] args) {

        if (args.length != 0) {
            // TODO: exception
            System.out.println("Error, wrong");
            return;
        }

        Session session = new Session();
        session.start();
    }

}
