# Overview

This repository contains a few tasks to implement during a developer interview task.

# TL;DR

1. Clone this repository.
1. Run the tests (`mvn test` or run `FileBasedProviderTest`).
1. Implement missing code so that all the tests pass.
1. Open `basic-test.html` and add needed CSS to `styles.css`. 
1. ???
1. PROFIT.

# More details

You **are allowed** to search the web for any API or code examples related to your tasks. You are **not allowed** to search for solutions ;) 

Whenever you are unclear about what exactly is expected, **ask immediately**.

## Java tasks

Look at `FileBasedProvider.read()` and start from there. Your task is to read contents of a file with CSV values (one entry per line).

Once the contents of the file are read, proceed to `FileBasedProvider.findAll()` and return all the data found in the file as a collection.

After that, look at `FileBasedProvider.search(...)` and implement it according to the documentation.

You have approximately 30 minutes, although this is not a hard limit. Once all the tests pass, congratulations!

## CSS tasks

Open `src/html/basic-test.html`. It describes three tasks to be accomplished by adding proper CSS rules to `src/html/styles.css`.

There is no *reference screenshot* associated with these tasks - anything that matches the specification will work.

You have approximately 45 minutes, although this is not a hard limit.