/*
 * Copyright 2013 Consulo.org
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
package org.consulo.ui;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.IconLoader;
import com.intellij.util.ui.EmptyIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VISTALL
 * @since 0:33/05.10.13
 */
public class ThemableIcon implements Icon {
  private static final List<ThemableIcon> ourKeys = new ArrayList<ThemableIcon>();

  static {
    ApplicationManager.getApplication().getMessageBus().connect().subscribe(UIThemeManager.TOPIC, new UIThemeChangeListener() {
      @Override
      public void themeChanged(@NotNull UITheme oldTheme, @NotNull UITheme newTheme) {
        for (ThemableIcon ourKey : ourKeys) {
          ourKey.myIcon = null;
        }
      }
    });
  }

  public static ThemableIcon create(@NotNull String key) {
    return new ThemableIcon(key);
  }

  public static ThemableIcon createNon(@NotNull final String url) {
    return new ThemableIcon(url) {
      @Override
      protected Icon resolveIcon() {
        return IconLoader.findIcon(url);
      }
    };
  }

  @NotNull
  private final String myKey;

  private Icon myIcon;

  private ThemableIcon(@NotNull String key) {
    myKey = key;
    ourKeys.add(this);
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    getDelegate().paintIcon(c, g, x, y);
  }

  @Override
  public int getIconWidth() {
    return getDelegate().getIconWidth();
  }

  @Override
  public int getIconHeight() {
    return getDelegate().getIconHeight();
  }

  protected Icon getDelegate() {
    if(myIcon != null) {
      return myIcon;
    }
    return myIcon = resolveIcon();
  }

  protected Icon resolveIcon() {
    UITheme currentTheme = UIThemeManager.getInstance().getCurrentTheme();
    Icon icon = currentTheme.getIcon(this);
    if(icon == null) {
      icon = EmptyIcon.ICON_0;
    }
    return icon;
  }

  @NotNull
  public String getKey() {
    return myKey;
  }
}
