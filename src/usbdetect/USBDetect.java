/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usbdetect;

/**
 *
 * @author Syed Aminul Islam
 * @version 1.0.0
 * 
 * Email: aminul666@gmail.com
 * Facebook: www.facebook.com/aminul666 
 * Website: www.aminul666.tk 
 *          syedaminulislam.users.sourceforge.net
 *
 * Copyright © 2012, Syed Aminul Islam. All Rights Reserved.
 */
import java.io.*;

/**
 *
 * @author Syed Aminul Islam
 */
public class USBDetect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N","O","P"};
        File[] drives = new File[letters.length];
        boolean[] isDrive = new boolean[letters.length];

        // init the file objects and the initial drive state
        for (int i = 0; i < letters.length; ++i) {
            drives[i] = new File(letters[i] + ":/");

            isDrive[i] = drives[i].canRead();
        }

        System.out.println("FindDrive: waiting for devices...");

        // loop indefinitely
        while (true) {
            // check each drive 
            for (int i = 0; i < letters.length; ++i) {
                boolean pluggedIn = drives[i].canRead();

                // if the state has changed output a message
                if (pluggedIn != isDrive[i]) {
                    if (pluggedIn) {
                        System.out.println("Drive " + letters[i] + " has been plugged in");
                    } else {
                        System.out.println("Drive " + letters[i] + " has been unplugged");
                    }

                    isDrive[i] = pluggedIn;
                }
            }

            // wait before looping
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { /*
                 * do nothing
                 */ }
        }
    }
}

