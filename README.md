# DisableChat - Spigot plugin
This plugin disables ingame chat functionality, its really fast, optimised and simple to use! This plugin required Java 8 or later runtime installed on your server!
> **_NOTE:_**  This plugin disables only the game chat function, in order to fully disallow players ability to send text you will need to remove his `minecraft.command.tell` and `minecraft.command.me` permissions too!
## Installation
Navigate to the [download page](https://github.com/Beocraft/DisableChat/releases/latest) and download the jar file, put it in your plugins forlder and then restart or reload (this plugin is optimised for server reloads but other plugins on your server may brake) the server. By default **only operatirs will be able to bypass the chat restriction**.
## Customisations
In order to unlock more features of this plugin you will need a *permission menagement plugin*! We recommend you to use **LuckPerms by Lucko** (you can download it from [spigotmc website](https://www.spigotmc.org/resources/luckperms.28140/)).
There are 2 permissions:
- `disablechat.admin` - Allows you to use ingame configuration commands
- `disablechat.bypass` - Players with this permission will be able to use the chat function
## Commands
There are only 3 commands:
- `/disablechat` or `/dc` - Shows the current server configuration
- `/disablechat enable` or `/dc enable` - Enables the plugin (disables the chat function)
- `/disablechat disable` or `/dc disable` - Disables the plugin (enables back the chat function)
> **_NOTE:_**  In order to use commands in game you are required to be a server operator or have a `disablechat.admin` permission !
## Libraries
This project uses the:
- [SPIGOT API](https://hub.spigotmc.org/stash/projects/SPIGOT) - Contains both open source code and closed source code owned by Mojang Studios AD (all of this code is only included in the distributable jar found in the releases tab of this project)
## License
This project uses the MIT Licence, please take a look at [LICENSE.md](LICENSE.md) for more information!
