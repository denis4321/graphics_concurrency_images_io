/**
 * Copyright (c) 1996-2004 Borland Software Corporation.  All Rights Reserved.
 * 
 * This SOURCE CODE FILE, which has been provided by Borland Software as part
 * of a Borland Software product for use ONLY by licensed users of the product,
 * includes CONFIDENTIAL and PROPRIETARY information of Borland Software.  
 *
 * USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS 
 * OF THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
 * THE PRODUCT.
 *
 * IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD BORLAND SOFTWARE, ITS
 * RELATED COMPANIES AND ITS SUPPLIERS, HARMLESS FROM AND AGAINST ANY
 * CLAIMS OR LIABILITIES ARISING OUT OF THE USE, REPRODUCTION, OR
 * DISTRIBUTION OF YOUR PROGRAMS, INCLUDING ANY CLAIMS OR LIABILITIES
 * ARISING OUT OF OR RESULTING FROM THE USE, MODIFICATION, OR
 * DISTRIBUTION OF PROGRAMS OR FILES CREATED FROM, BASED ON, AND/OR
 * DERIVED FROM THIS SOURCE CODE FILE.
 */
//------------------------------------------------------------------------------
// Copyright (c) 1996-2004 Borland Software Corporation.  All Rights Reserved.
//------------------------------------------------------------------------------

package com.borland.samples.welcome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeFrame extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();

  /**
   * Construct the frame
   */
  public WelcomeFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Component initialization
   *
   * @throws Exception exception
   */
  private void jbInit() throws Exception {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setTitle("Welcome to JBuilder");
    this.setJMenuBar(jMenuBar1);
    this.setSize(new Dimension(400, 300));
    jMenuFile.setText("File");
    jMenuFileExit.setText("Exit");
    jMenuFileExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileExit_actionPerformed(e);
      }
    });
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.setText("Help");
    jMenuHelpAbout.setText("About");
    jMenuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuHelpAbout_actionPerformed(e);
      }
    });
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
  }

  /**
   * Overridden so we can exit when window is closed
   *
   * @param e WindowEvent
   */
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  /**
   * File | Exit action performed
   *
   * @param e ActionEvent
   */
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  /**
   * Help | About action performed
   *
   * @param e ActionEvent
   */
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
  }
}
