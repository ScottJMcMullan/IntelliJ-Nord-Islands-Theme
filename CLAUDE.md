# Nord Islands - IntelliJ Theme Plugin

## Project Overview

A dark UI theme for JetBrains IDEs based on the [Nord color palette](https://www.nordtheme.com/) with full Islands UI
support. Published to the JetBrains plugin marketplace.

## Nord Color Palette Reference

| Name    | Hex                   | Role                              |
|---------|-----------------------|-----------------------------------|
| Nord 0  | `#2e3440`             | Primary background                |
| Nord 1  | `#3b4252`             | Elevated/secondary surface        |
| Nord 2  | `#434c5e`             | Selection highlight               |
| Nord 3  | `#4c566a` / `#616e88` | Dimmed text, comments             |
| Nord 4  | `#d8dee9`             | Primary foreground text           |
| Nord 5  | `#e5e9f0`             | Secondary bright text             |
| Nord 6  | `#eceff4`             | Brightest text, punctuation       |
| Nord 7  | `#8fbcbb`             | Teal - classes/interfaces         |
| Nord 8  | `#88c0d0`             | Cyan - primary accent, functions  |
| Nord 9  | `#81a1c1`             | Blue - keywords, secondary accent |
| Nord 10 | `#5e81ac`             | Deep blue                         |
| Nord 11 | `#bf616a`             | Red - errors                      |
| Nord 12 | `#d08770`             | Orange - warnings, annotations    |
| Nord 13 | `#ebcb8b`             | Yellow - info, strings escape     |
| Nord 14 | `#a3be8c`             | Green - strings, success          |
| Nord 15 | `#b48ead`             | Purple - numbers                  |

## Project Structure

```
├── build.gradle.kts                          # Build config (IntelliJ Platform Gradle Plugin 2.5.0)
├── resources/
│   ├── META-INF/
│   │   ├── plugin.xml                        # Plugin manifest and metadata
│   │   ├── pluginIcon.svg                    # Marketplace icon (light)
│   │   └── pluginIcon_dark.svg               # Marketplace icon (dark)
│   └── theme/
│       ├── intellijnordislandstheme.theme.json  # UI theme definition (colors, components, icons)
│       └── nord-islands.xml                     # Editor color scheme (syntax highlighting)
```

## Key Files

- **`build.gradle.kts`** — Gradle build using `org.jetbrains.intellij.platform` plugin v2.5.0. Targets IntelliJ IDEA
  Ultimate 2025.3. Version is set here.
- **`resources/META-INF/plugin.xml`** — Plugin ID: `com.scottmcmullan.nord-islands-theme`. Defines min IDE version (
  `since-build`), description, and registers the theme via `<themeProvider>`.
- **`resources/theme/intellijnordislandstheme.theme.json`** — Main theme file. Parent theme: `ExperimentalDark`.
  Contains:
    - `colors` — Named color aliases used throughout
    - `ui` — Per-component styling (Islands config, tabs, trees, buttons, popups, terminal, etc.)
    - `icons.ColorPalette` — Icon tinting overrides
- **`resources/theme/nord-islands.xml`** — Editor color scheme. Parent: `Darcula`. Defines syntax highlighting for PHP,
  JS/TS, HTML, CSS, JSON, YAML, Markdown. Also covers diff colors, VCS gutter, console ANSI, rainbow braces, etc.

## Build & Test

```bash
# Build the plugin
./gradlew buildPlugin

# Run a sandboxed IDE with the theme installed
./gradlew runIde

# Build distributable zip
./gradlew buildPlugin  # output in build/distributions/
```

Publishing requires a `PUBLISH_TOKEN` environment variable for the JetBrains marketplace.

## Development Notes

- The theme JSON `colors` section defines reusable color aliases; the `ui` section references these by name (e.g.,
  `"accent"` resolves to `#88c0d0`).
- Islands UI is enabled with `"Islands": 1` in the `ui.*` section. Arc values control corner rounding.
- The editor scheme XML uses `option` elements with `value` attributes for hex colors. Syntax elements are in
  `<attributes>` with `<option name="FOREGROUND" value="..."/>` patterns.
- When adding new UI component colors, check
  the [IntelliJ Platform Theme Reference](https://plugins.jetbrains.com/docs/intellij/themes-getting-started.html) for
  available keys.
- All colors should come from the Nord palette — don't introduce arbitrary hex values.
