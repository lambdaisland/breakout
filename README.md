# breakout

A level editor for the retro game "Breakout", built with
[re-frame](https://github.com/Day8/re-frame) , as seen on
[Lambda Island episode 19](https://lambdaisland.com/episodes/re-frame).

You can [try it out on-line](https://lambdaisland.github.io/breakout/).

If you want to follow along, then check out the
[re-frame-start](https://github.com/lambdaisland/breakout/tree/re-frame-start)
branch, and start from there. The final result is in the
[re-frame-episode-1](https://github.com/lambdaisland/breakout/tree/re-frame-episode-1) branch.

```
git clone https://github.com/lambdaisland/breakout.git
cd breakout
git checkout re-frame-start
```

## Development Mode

### Start Cider from Emacs:

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl "(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
