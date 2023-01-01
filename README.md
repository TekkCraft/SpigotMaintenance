# Spigot Maven Base
This project is a simple skeleton to make getting started with Minecraft Spigot plugins using Maven easier.

## Version
This example is written for the Minecraft version 1.19.2.

## Included
* Very basic plugin structure
* Maven integration
* Maven Shade example
* Example for a command including config.yml & plugin.xml example
* Example for an event listener

## Installing Maven
Download Maven: https://maven.apache.org/download.cgi  
Install Maven: https://maven.apache.org/install.html

## Spigot Build Tools
Build your Spigot server jar using the SpigotBuildTools.
THe Spigot jar is also required for development.  
https://www.spigotmc.org/wiki/buildtools/

## DEV Server Setup
Setup of a local spigot server to test your plugins.  
https://www.spigotmc.org/wiki/spigot-installation/

## Integrate Spigot Dependency in IntelliJ
Integrate Spigot dependency into JetBrain's IntelliJ IDEA.  
https://www.spigotmc.org/wiki/creating-a-blank-spigot-plugin-in-intellij-idea/

## Integrate Spigot Dependency in Eclipse
Integrate Spigot dependency into Eclipse.  
https://www.spigotmc.org/wiki/creating-a-blank-spigot-plugin-in-eclipse/

## Setup
* Clone repository or download source code
* Rename org.example.spigotmavenbase to your preferred package name (See "[Naming your package](#naming-your-package)")
* Make the necessary adjustments as instructed in the pom.xml
* Make the necessary adjustments as instructed in the plugin.yml

## Naming your package
(Source: https://www.spigotmc.org/wiki/creating-a-blank-spigot-plugin-in-intellij-idea/)  
You can name your package following these guidelines:
* Only lowercase letters
* No spaces
* Dots act as folder separators
* To avoid conflicts with other plugins with the same Main class directory, the general guideline is:
    * If you own a website or a domain, set the package name to [tld].[domain].[pluginname]
    * If you don't, use me.[yourname].[pluginname] or [country].[yourname].[pluginname]
    * If both are taken, try your email, e.g. com.gmail.[partofemailbefore@].[pluginname]
    * *note: the IDE cant tell you if your package already exists for another plugin, you have to make sure by yourself. You can simply google the name.

## Generate jar
To generate the plugin jar file to be used in your server open CMD in the root directory of the source code and run `mvn package`.  
The jar will be generated in `target/SpigotMavenBase.jar`.

## Testing your plugin
Move the generated jar into the plugins folder of your server and run the `/reload` command.  
> :warning: The `/reload` command may lead to problems. Try fully restarting your server if you run into any issues.

## Troubleshooting
If there is any problem with **IntelliJ** not recognising resources (especially shaded packages):
* Right-click the `pom.xml` file
* Maven => Reload Project