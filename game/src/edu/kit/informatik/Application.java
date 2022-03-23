package edu.kit.informatik;

import edu.kit.informatik.ui.Session;

public final class Application {

    private Application() {

    }

    public static void main(String[] args) {
        Session session = new Session();
        session.start();
    }
    
}
