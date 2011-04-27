
clj-bitbucket : BitBucket API bindings for Clojure.
=======================================================

`clj-bitbucket` supports the entire documented [RESTful BitBucket API](http://confluence.atlassian.com/x/IYBGDQ).

Usage and Examples
==================

TODO



Installation
============

### With Leiningen or Cake

TODO

### Via Source

TODO


TODO
====


Hacking
=======

### Using TMUX or screen

If you want to start a new tmux server, cd to the project root dir, just type:
    tmux -f tmux-screen/clj-bitbucket.tmux.conf
otherwise you can start a new session:
    tmux `cat tmux-screen/clj-bitbucket.tmux.newsession`
You can also use screen:
    screen -c tmux-screen/clj-bitbucket-screenrc -S clj-bitbucket


### VimClojure tips

Start a nailgun (which will also open a repl),
run the following command from the project root:
    script/nailgun
You can also run a rlwrap'd REPL that VimClojure can connect to:
    lein repl
And then call the Nailgun server function:
    (runnail)
or more commonly,
    (def nail (runnail))

Here are helpful commands
    * \rt - run tests in the given namespace
    * \lw - lookup word
    * \li - lookup interactive
    * \gw - goto word
    * \sw - source lookup word
    * \el - eval line
    * \ep - eval paragraph
    * \ef - eval file
    * \me - macroexpand
    * \m1 - macroexpand1
    * \rf - require the file

### Paredit.vim tips

I also make use of the paredit.vim file from the slimv.vim plugin. This assumes your <leader> is \
    * :call ToggleParedit - toggle it on and off.
    * \W wrap in paren (works with visual selection too)
    * \J join paren - (a)(b) -> (a b)
    * \O split paren - (a b) -> (a)(b)
    * \S splice paren - ((a b)) -> (a b)
Wrapping can also be tailored, and used on a visual block:
    * \w"
    * \w[
    * \w(


### CDT - Clojure Debugging toolkit

You can start a debugging REPL with: `lein cdt`
    (set-catch java.lang.IllegalArgumentException :all)
    (delete-catch java.lang.IllegalArgumentException)
    (print-frames)
    (up)
    (down)
    (cont)
    (set-bp clojure.core/into)
    (delete-bp clojure.core/into)
    (local-names)
    (locals)
    (reval)
    (reval-println)


### Running the tests

From the project root, `./script/lazytest` will run all the tests.
To start a test watcher, `./script/lazytest-watch`


License
=======

    Copyright (C) 2010 Paul deGrandis. All rights reserved.
    Distributed under the Eclipse Public License, the same as Clojure.
	
	The use and distribution terms for this software are covered by the 
	Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) 
	which can be found in the file LICENSE.html at the root of this distribution. 
	By using this software in any fashion, you are agreeing to be bound by the terms of this license. 
	You must not remove this notice, or any other, from this software.

