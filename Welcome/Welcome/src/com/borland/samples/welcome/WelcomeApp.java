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
import javax.swing.UIManager;

public class WelcomeApp {
  boolean packFrame = false;

  /**
   * Construct the application
   */
  public WelcomeApp() {
    WelcomeFrame frame = new WelcomeFrame();

    //Pack frames that have useful preferred size info, e.g. from their layout
    //Validate frames that have preset sizes
    if (packFrame)
      frame.pack();
    else
      frame.validate();

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    frame.setVisible(true);
  }

  /**
   * Main method
   *
   * @param args String[]
   */
  static public void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new WelcomeApp();
  }
}
