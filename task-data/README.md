# Overview

This module contains a general programming task.

# TL;DR

1. Clone this repository.
1. Run the tests (`mvn test` or run `FileBasedProviderTest`).
1. Implement missing code so that all the tests pass.
1. ???
1. PROFIT.

# More details

You **are allowed** to search the web for any API or code examples related to your tasks. You are **not allowed** to search for solutions ;) 

Whenever you are unclear about what exactly is expected, **ask immediately**.

## General programming task

Look at `FileBasedProvider.read()` and start from there. Your task is to read contents of a file with CSV values (one entry per line).

Once the contents of the file are read, proceed to `FileBasedProvider.findAll()` and return all the data found in the file as a collection.

After that, look at `FileBasedProvider.search(...)` and implement it according to the documentation.

You have approximately 30 minutes, although this is not a hard limit. Once all the tests pass, congratulations!
