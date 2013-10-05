
/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.ide.ui.laf.light;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 * @author Konstantin Bulenkov
 */
public class LightMetalTheme extends DefaultMetalTheme {

 /* private final ColorUIResource myControlHighlightColor = new ColorUIResource(SystemColor.CONTROL_LT_HIGHLIGHT);
  private final ColorUIResource myControlDarkShadowColor = new ColorUIResource(SystemColor.CONTROL_HIGHLIGHT);
  private final ColorUIResource myControlColor = new ColorUIResource(SystemColor.CONTROL);
  private static final ColorUIResource white = new ColorUIResource(255, 255, 255);
  private static final ColorUIResource darkBlue = new ColorUIResource(82, 108, 164);
  private static final ColorUIResource lightGray = new ColorUIResource(214, 214, 214);
  private final ColorUIResource mySeparatorForeground = new ColorUIResource(53, 56, 58);
        */
 /* public static final ColorUIResource primary1 = new ColorUIResource(0, 0, 0);
  private static final ColorUIResource primary2 = new ColorUIResource(204, 204, 204);
  private static final ColorUIResource primary3 = new ColorUIResource(255, 255, 255);

            */

  public String getName() {
    return "Light theme";
  }

  private static final ColorUIResource primary1 = new
    ColorUIResource(0, 0, 0);
  private static final ColorUIResource primary2 = new ColorUIResource(
    204, 204, 204);
  private static final ColorUIResource primary3 = new ColorUIResource(255,
                                                                      255, 255);
  private static final ColorUIResource primaryHighlight = new
    ColorUIResource(102, 102, 102);
  private static final ColorUIResource secondary2 = new ColorUIResource(
    204, 204, 204);
  private static final ColorUIResource secondary3 = new ColorUIResource(
    255, 255, 255);
  private static final ColorUIResource controlHighlight = new
    ColorUIResource(102, 102, 102);



  protected ColorUIResource getPrimary1() {
    return primary1;
  }

  protected ColorUIResource getPrimary2() {
    return primary2;
  }

  protected ColorUIResource getPrimary3() {
    return primary3;
  }

  public ColorUIResource getPrimaryControlHighlight() {
    return primaryHighlight;
  }

  protected ColorUIResource getSecondary2() {
    return secondary2;
  }

  protected ColorUIResource getSecondary3() {
    return secondary3;
  }

  public ColorUIResource getControlHighlight() {
    // This was super.getSecondary3();
    return secondary2;
  }

  public ColorUIResource getFocusColor() {
    return getBlack();
  }

  public ColorUIResource getTextHighlightColor() {
    return getBlack();
  }

  public ColorUIResource getHighlightedTextColor() {
    return getWhite();
  }

  public ColorUIResource getMenuSelectedBackground() {
    return getBlack();
  }

  public ColorUIResource getMenuSelectedForeground() {
    return getWhite();
  }

  public ColorUIResource getAcceleratorForeground() {
    return getBlack();
  }

  public ColorUIResource getAcceleratorSelectedForeground() {
    return getWhite();
  }
}
