package client;

import java.awt.EventQueue;

import client.communication.ClientCommunicator;
import client.model.Facade;
import client.util.ClientLogManager;
import client.view.IndexerFrame;
import client.view.LoginDialog;

public class Client {
  private static final String USAGE_MESSAGE = "Usage: java client.Client <host> <port>";

  /**
   * Entry point for the Indexer Server program.
   *
   * @param args the port to run the indexer server on
   */
  public static void main(String[] args) {
    ClientLogManager.initLogs();

    if (args.length == 2) {
      try {
        final String host = args[0];
        final int port = Integer.parseInt(args[1]);

        Facade.setClientCommunicator(new ClientCommunicator(host, port));
        EventQueue.invokeLater(new Runnable() {
          public void run() {
            new LoginDialog();
          }
        });
      } catch (NumberFormatException ex) {
        System.out.println(USAGE_MESSAGE);
      }
    } else {
      System.out.println(USAGE_MESSAGE);
    }
  }
}
