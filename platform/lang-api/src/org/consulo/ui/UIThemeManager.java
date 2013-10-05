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

import com.intellij.util.messages.Topic;
import org.consulo.lombok.annotations.ApplicationService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author VISTALL
 * @since 0:01/05.10.13
 */
@ApplicationService
public abstract class UIThemeManager {
  public static final Topic<UIThemeChangeListener> TOPIC = Topic.create("ui theme change listener", UIThemeChangeListener.class);

  @Nullable
  public abstract UITheme findTheme(@NotNull String name);

  @NotNull
  public abstract UITheme getCurrentTheme();
}
