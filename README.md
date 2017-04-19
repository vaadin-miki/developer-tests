# Overview

This repository contains a simple project to implement during a developer interview task.

# TL;DR

1. Clone this repository.
2. Run the tests (`mvn test` or run `FileBasedProviderTest`).
3. Implement missing code so that all the tests pass.
4. ???
5. PROFIT.

# More details

You **are allowed** to search the web for any API or code examples related to this project. You are **not allowed** to search for a solution ;) 

Look at `FileBasedProvider.read()` and start from there. Your task is to read contents of a file with CSV values (one entry per line).

Once the contents of the file are read, proceed to `FileBasedProvider.findAll()` and return all the data found in the file as a collection.

After that, look at `FileBasedProvider.search(...)` and implement it according to the documentation.

You have approximately 30 minutes, although this is not a hard limit. Once all the tests pass, congratulations!