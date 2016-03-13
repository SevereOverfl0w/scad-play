# Scad Play

Based loosely on
https://adereth.github.io/blog/2014/04/09/3d-printing-with-clojure/
I wanted an environment I could get started with easily when building 3D
models.

## Usage
```
boot dev

# ...

dev=> (go)
dev=> (reset)
```

On `(reset)`, you will find that the file is rewritten. The model is just
Stuart Sierra's reloaded workflow. Like him, I advise you bind `(reset)` to a
key in your editor. This plays nicely with OpenSCAD's built-in file reload
capabilities. Open the written file (target/demo.scad), in OpenSCAD and see
your model update in front of you in real time.
