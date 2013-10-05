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

import org.consulo.ui.ThemableIcon;
import org.consulo.ui.UITheme;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.localmatters.lesscss4j.model.RuleSet;
import org.localmatters.lesscss4j.model.Selector;
import org.localmatters.lesscss4j.model.StyleSheet;

import javax.swing.*;
import java.util.List;

/**
 * @author VISTALL
 * @since 0:48/05.10.13
 */
public class UIThemeImpl implements UITheme {
  private static final Selector GLOBAL = new Selector("global");
  private static final Selector TEXT_ATTRIBUTES = new Selector("textAttributes");
  private static final Selector ICONS = new Selector("icons");

  private final StyleSheet myStyleSheet;
  private String myName;

  public UIThemeImpl(StyleSheet styleSheet) {
    myStyleSheet = styleSheet;
    List<RuleSet> ruleSet = styleSheet.getRuleSet(GLOBAL);

  }

  @Nullable
  @Override
  public Icon getIcon(ThemableIcon themableIcon) {
    return null;
  }

  @NotNull
  @Override
  public String getName() {
    return myName;
  }
}
