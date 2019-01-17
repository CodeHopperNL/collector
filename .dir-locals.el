;;;; this sets up some formatting preferences in emacs
;;;;
;;;; Note that this applies the clojure/refactoring settings to all
;;;; buffers open in the backend tree, regardless of mode, since most
;;;; vars need to be available in non-clojure buffers (like the
;;;; CIDER/NREPL connection buffer).
;;;;
((nil . (
;;;
;;; backend project is clojure/leiningen
;;;
         (projectile-project-type . lein-test)
;;;
;;; Some formatting / styling settings to obey for the project
;;;
         (clojure-align-forms-automatically . t) ; enable vertical alignment
         (cljr-favor-prefix-notation . nil) ; do not use prefix notation in :require
         (cljr-clojure-test-declaration . "[clojure.test :refer [deftest testing is]]")
;;;
;;;  Fix & speed up CLJ Refactor mode
;;;
         (cljr-warn-on-eval . nil)           ; (otherwise, no cache for you)
         ;;  speed up `cljr-add-project-dependency`
         (cljr-populate-artifact-cache-on-startup . t)
         ;; speed up `cljr-find-usages` and related refactorings
         (cljr-eagerly-build-asts-on-startup . t)
         ;; ensure we load all namespaces when CIDER starts, before
         ;; warming AST cache, otherwise code analysis will break on
         ;; keywords qualified with namespace aliases.
         ;;
         ;; without this tricky bit, `cljr-find-usages` etc will only
         ;; work after you manually call `cider-load-all-project-ns`
         (eval . (with-eval-after-load "clj-refactor"
                   (add-hook 'cider-connected-hook #'cider-sync-request:ns-load-all))))))
