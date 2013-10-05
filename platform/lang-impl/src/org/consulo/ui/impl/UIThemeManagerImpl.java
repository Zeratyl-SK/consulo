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
package org.consulo.ui.impl;

import org.consulo.lombok.annotations.Logger;
import org.consulo.ui.BundledUIThemeEP;
import org.consulo.ui.UITheme;
import org.consulo.ui.UIThemeManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.localmatters.lesscss4j.error.AbstractErrorHandler;
import org.localmatters.lesscss4j.model.StyleSheet;
import org.localmatters.lesscss4j.parser.InputStreamStyleSheetResource;
import org.localmatters.lesscss4j.parser.LessCssStyleSheetParser;
import org.localmatters.lesscss4j.parser.StyleSheetParser;

import java.io.InputStream;

/**
 * @author VISTALL
 * @since 0:03/05.10.13
 */
@Logger
public class UIThemeManagerImpl extends UIThemeManager {
  private static class LessErrorHandler extends AbstractErrorHandler {
    @Override
    public void handleError(String message, Throwable exception) {
      super.handleError(message, exception);
      LOGGER.error(message, exception);
    }
  }


  public UIThemeManagerImpl() {
    load();
  }

  private void load() {
    StyleSheetParser parser = new LessCssStyleSheetParser();

    for (BundledUIThemeEP ep : BundledUIThemeEP.EP_NAME.getExtensions()) {
      try {
        InputStream resourceAsStream = ep.getPluginDescriptor().getPluginClassLoader().getResourceAsStream(ep.file);

        LessErrorHandler handler = new LessErrorHandler();

        StyleSheet styleSheet = parser.parse(new InputStreamStyleSheetResource(resourceAsStream), handler);

        if(handler.getErrorCount() > 0) {
          continue;
        }

        UIThemeImpl theme = new UIThemeImpl(styleSheet);
      }
      catch (Exception e) {
        LOGGER.error(e);
      }
    }
  }

  @Nullable
  @Override
  public UITheme findTheme(@NotNull String name) {
    return null;
  }

  @NotNull
  @Override
  public UITheme getCurrentTheme() {
    return null;
  }
}
