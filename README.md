# About
Spellbook is an application that allows you to browse a list of spells available for DND 5e.

![Screenshot_1705935123](https://github.com/davidcrotty/itemcatalogue/assets/7389468/e784d050-690b-4427-974d-3d52f689558f)
![Screenshot_1705935141](https://github.com/davidcrotty/itemcatalogue/assets/7389468/2cc304d8-1166-4a58-b3be-d77f98d84216)

# Setup
The project requires an API key to run, this has been temporarily made available in gradle/keys.properties for ease of setup.

However it is security best practice to not include API keys in an application.

# Structure
The project is setup in the following structure:

![overview](https://github.com/davidcrotty/itemcatalogue/assets/7389468/93fcf416-7b77-4812-967d-2eb4792f28a7)

* **App** is the compositional root. This fulfills the dependencies of other modules and allows talking to each other via abstraction. This is the only module that knows about all other modules.

* **feature:detailscreen** Contains presentation and UI layers for the detail screen.

* **feature:listscreen** Contains presenation and UI layers for the listscreen

* **domain** Contains Entities, usercases and contracts that are business logic related. Does not depend on other modules

* **data** Depends on domain, Fulfills data contracts of the domain and accesses the network to fulfil http requests for the application.

* **core** Common testing functionality used across other modules (ie: co routine test extentions)

* **theme** Contains common design components such as tokens and values feature modules use

