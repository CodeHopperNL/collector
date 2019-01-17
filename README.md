# Email Collector

A clojure[script] webapp written to demonstrate how web development works with such a lispy language.
This simple app shows a form to the user to collect her email address, stores such data into a PostgreSQL
database and displays a thank you note at the end of the process.

## Incremental builds

This project is implemented one step at a time to show how to add specific features one by one.
Have a look at the tags in the git repository to see the development unfolding before your eyes!

## Installation

You need to [install clojure][install] first:

    brew install clojure

## Usage

You can start the server with:

```sh
clj -A:figwheel
```

Then your browser will automatically open the page at `http://localhost:9500`

# License

Source Copyright © 2009-2018 Code Hopper

Distributed under [the Eclipse Public License][epl], the same as Clojure
uses. See the file `LICENSE.txt`.


[epl]: https://www.eclipse.org/legal/epl-v10.html
[install]: https://clojure.org/guides/getting_started
