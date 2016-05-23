(ns clojure-web-tutorial.pages
  (:gen-class)
  (:use hiccup.core
        hiccup.page
        hiccup.element))

(defn header
  "Head tag for each page"
  [page-title]
  [:head
    [:title page-title]
    ;; require bootstrap
    (hiccup.page/include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")])


(defn intro-page
  "Landing page for the tutorial."
  []
  (html
    (header "Introductory Tutorial for Simple Clojure Web Development")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 1: Background and Setup"]

        [:p "Clojure is a functional programming language created by Rich Hickey.  It uses the syntax of Lisp
              and it runs on the Java Virtual Machine.  It emphasizes immutable data structrues and is written as
              a nested set of S-Expressions, the basic building blocks of Clojure functions.

              Why write a web app in Clojure?  It's designed with simplicity in mind, and it has good library support
               along with access to Java functionality.  Unlike web frameworks which include many depencencies, we can build a basic
               Clojure web app with only three open-source libraries:"]

        [:ul
          [:li "Ring, for basic web server functinality"]
          [:li "Compojure, for routing"]
          [:li "Hiccup, for HTML templating"]]

        [:p "This tutorial will explain how to get set up with a minimal Clojure web development setup by walking you through the process
              of making this site and deploying it to run in the cloud."]

        [:h3 "Setting up Leiningen and JDK"]
        [:p "To run Clojure on your computer, you'll need Leiningen and the Java Development Kit installed.  Leiningen is a project
              management tool that allows the easy creation of Clojure projects and management of depencencies.
              The Java Development Kit is what allows you to execute the Java bytecode that is generated when Clojure compiiles.
              You can find the latest JDK here This tutorial is assuming you are on OSX or Linux, but this can be done
               on windows as well.  For details on getting set up with Windows you can refer to "
              (link-to "https://levlaz.org/installing-leiningen-on-windows/" "this tutorial")]

        [:p "To install Leiningen on a Mac you can use Homebrew with "
            [:b "brew install leiningen"]
            ". For information on other
            setups you can go here: "]

        [:p "Once you have leiningen installed, you can initialize a new app with " [:b "lein new app clojure-web-tutorial"] " and change into that directory."]

        [:p "This will generate a project folder structure for a project named "
            [:b "clojure-web-tutorial"]
            " Inside this folder you will see a "
            [:b "src/clojure-web-tutorial"] "directory.  This contains a file called "
            [:b "core.clj"]
            " which is the main entry point for writing source code for our app.  Other clojure code you add will also live
              in this directory. "]

        [:p "The other most important file is "
            [:b "project.clj"]
            ". This is a file used by Leiningen to manage your depencencies.
              Each Clojure file will have its own namespace, which can then be
              used to require code across files.  You can get a more detailed
              view of Leiningen project structure "
            (link-to "http://alexott.net/en/clojure/ClojureLein.html" "here")
            ". Before going any further you should learn the basics of Clojure
              syntax if you haven't already.  You can add the three libraries we'll
              need by adding the following lines into the :dependencies vector"]

        [:p "<script src=\"https://gist.github.com/jholkeboer/cee05d0616e395b110cdee0bdaa19f12.js\"></script>"]

        [:p "Then, in "
          [:b "core.clj"]
          " you can edit the main function to do whatever you want.  On the command line,
                      you can run the app by doing "
          [:b "lein run.  It will then execute in the main function.  In the next step we'll learn how to make it run a web server."]
          "."]


        [:p (link-to {:class "btn btn-primary"} "/pages/2" "Next page >")]
        [:br]]]))

(defn clojure-specifics
  "Explains how Clojure development is a little different than what you're used to."
  []
  (html
    (header "What makes Clojure different?")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 2: What makes Clojure different?"]
        [:br]

        [:p "In a typical web development framework, you use a programming langauge to write server endpoints and you use an
              HTML templating langauge to place whatever is returned by the web server in the appropriate spot in the
              page that is returned to the user.  This usually entails keeping HTML files separate from application logic and
              inserting values based on special characters introduced in the html.  The HTML file is then referenced by the web server,
              sometimes with parameters attached which are rendered in the template."]

        [:p "With Clojure, we can avoid the use of HTML files at all by leveraging the Hiccup library.  In this tutorial you'll
              see how HTML files can be generated by functions within the same logic as the server.  It allows you to do more flexible
               logic than that is provided by a typical templating language.  You can write as much code as you want and then insert
               any derived values as parameters to Hiccup's " [:b "HTML"] " function."]

        [:p "To get a basic web endpoint set up, we'll use the Ring and Compojure libraries that we required in the last step."]


        [:p "Ring leverages the Java Jetty library to create a web server endpoint on the jvm.  By changing your main function on core.clj
             to the following, you can set up a basic endpoint that returns a string on the port of your chocie: "]

        [:p "<script src=\"https://gist.github.com/jholkeboer/7820eb03b4e7072afafd2a498d2a7225.js\"></script>"]

        [:p "Once you've made that change, go to the command line an do "
            [:b "lein run"]
            ". You should then be able to go to localhost
            at that port and see the string that you put in.  In the above example, you would go to http://localhost:5000 and
            you would see the string \"It's working!\""]


        (link-to {:class "btn btn-primary"} "/pages/1" "< Previous page")
        (link-to {:class "btn btn-primary"} "/pages/3" "Next page >")
        [:br]]]))

(defn setting-up-routes
  "Shows how to use Compojure and Ring to set up routing and return a page."
  []
  (html
    (header "Setting up routes with Compojure")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 3: Setting up routes with Compojure"]
        [:br]

        [:p "Using the app-routes macro provided by Compojure, you can define the behaviors that will happen when different
              types of requests are made to different ports on your server.  You can then reference this function in the call
              to " [:b "jetty/run-jetty"]]

        [:p "<script src=\"https://gist.github.com/jholkeboer/d6633033a8e9f952389f80624733b98e.js\"></script>"]

        [:p "In this example, when GET requests are made to the \"/\" route, it will say \"We're on page 1\".  If there is a request to a url
               like \"pages/2\", then it will return the string \"We're on page 2\"."]

        [:p "For this tutorial, I decided to create a new method called "
            [:b "get-pages"]
            " which contains a conditional statement
            deciding which route to use.  The routes are just like any other Clojre form, and they can be passed as parameters to the
            app-routes macro.  We can then paginate our tutorial using these two routes:"]

        [:h3 "Refactoring your page functions"]
        [:p "Having all your pages defined in one function could get messy, especially when all the HTML content is mixed in.
                  To manage complexity, we can pull the functions that generate our pages out into a separate file."]

        [:p "Create the file " [:b "src/clojure_web_tutorial/pages.clj"] " and add the following to it: "]

        [:p "<script src=\"https://gist.github.com/jholkeboer/8c61b270022803c46ea82cc6b9b0388d.js\"></script>"]

        [:p "Then go to core.clj and add "
            [:b "[clojure-web-tutorial.pages :as pages]"]
            " to the list under :require.  Finally, add
            " [:b "(:use hiccup.core)"]
            " to the namespace statement.  The top of your core.clj file should look like this: "]

        [:p "Then in pages.clj, we can add a function for each page.  At the bottom of the file, the get-pages method
                    calls the right page based on the pagenumber parameter it gets.  Here's the code for this page, and its call in get-pages: "]

        [:p "<script src=\"https://gist.github.com/jholkeboer/a6cc932a3d93476552891333eb3fcbd2.js\"></script>"]

        [:p "And in core.clj, we can use that function in our app-routes to render a different page function based on the parameter.
                    In our example this page number parameter allows us to use one route for all pages."]

        [:p "<script src=\"https://gist.github.com/jholkeboer/7c38809266db03cdfd2eec01810ff589.js\"></script>"]

        [:p "On the next page, I'll explain more about how HTML pages are generated."]

        [:p (link-to {:class "btn btn-primary"} "/pages/2" "< Previous page")
          (link-to {:class "btn btn-primary"} "/pages/4" "Next page >")]
        [:br]]]))


(defn templating
  "Shows how to use hiccup to insert data in a webpage."
  [pagenumber]
  (html
    (header "HTML templating with Hiccup")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 4: HTML templating with Hiccup"]
        [:br]

        [:p "Each page function in our pages.clj file returns the result of a call to the (html ... ) function
              provided by Hiccup.  Most of our page functions for this tutorial don't take any parameters because they
              are not dynamically generated based on input. (However, this doesn't mean they're static files either - they're
              HTML strings generated by a Clojure function each time a request is made."]

        [:p "For this page, we added a parameter called "
            [:b "pagenumber"]
            ", which is convenient because this is getting passed
            down by the route for this page anyway.  In get-pages, we call it like this: "]

        ;; parameter used here
        [:p "This pagenumber can then be used as a parameter like this: " pagenumber
            [:br]
            "^Look at the source to see how it renders this number."]

        [:p "You can see how it's used in the source code for pages.clj below. "]

        [:h2 "How to generate html tags"]

        [:p "Each call to (html... ) generates an HTML string, but it doesn't necessarily need to comprise a whole page.
                In our example, we create a (header ... ) function which can then be called to insert the same header on
                every page:"]

        [:p "In this file, we can see how tags are structured.  Each tag is a vector where the first element is the tag name in
                :keyword form.  The next parameter, which is optional, is a map with settings for the tag.  This is followed by a string which
                is what would appear between the tags in html. For example to recreate
                the HTML paragraph tag with class='paragraph', you would use " [:b "[:p {:class \"paragraph\"} \"MyParagraph\"]"] "."]

        [:p "You can use this format to create deeply nested html structures.
            Check out the entire source code for pages.clj below.  You can see we also use hiccup's (link-to ... ) function
            to create links.  At the end of the function, you can see where each page's page number is used to choose a page function."]

        [:p "<script src=\"https://gist.github.com/jholkeboer/ed2f4db2e15d5cd5a45159877311f766.js\"></script>"]

        [:p (link-to {:class "btn btn-primary"} "/pages/3" "< Previous page")
          (link-to {:class "btn btn-primary"} "/pages/5" "Next page >")]
        [:br]]]))

(defn styling
  "Shows how to use include CSS files"
  []
  (html
    (header "Using CSS and Javascript")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 5: Using CSS and JavaScript"]
        [:br]

        [:p "We can use Hiccup's "
            [:b "(include-css ... )"]
            " and "
            [:b "(include-js)"]
            "functions to require stylesheets and
            JavaScript files to be used in our pages.  This is analogous to linking style sheets and requiring scripts with
            script tags in HTML.  In this example, we can use the Bootstrap CSS framework to style our site by including it
            in our <head> tag: "]

        [:p "<script src=\"https://gist.github.com/jholkeboer/b19d4c3f48bc245935bcfe6f7c8ddf02.js\"></script>"]

        [:p "We can then use Bootstrap to give our page body some style by putting all our content in a
            div with class='container' with the clojure vector "
            [:b "[:div {:class \"container\"}]"]
            ".  For more information
            on how to style your page with bootstrap, you can go "
            (link-to "https://www.pluralsight.com/courses/bootstrap-introduction" "here")
            ". Otherwise, you can use any CSS you want as long as you
            create your html elements in the way described here."]


        [:p "If you'd rather use a local file, you can add them in the "
            [:b "/resources/public"]
            " directory. For example, stylesheets would go in /resurces/public/css
            and scripts would go in /resources.public/js."]



        (link-to {:class "btn btn-primary"} "/pages/4" "< Previous page")
        (link-to {:class "btn btn-primary"} "/pages/6" "Next Page >")
        [:br]]]))

(defn deployment
  "Shows how to deploy to Heroku"
  []
  (html
    (header "Deployment")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 6: Deployment"]
        [:br]

        [:p "You should be able to deploy this app to any cloud provider that supports Java.  For this
            tutorial we'll use Heroku since it's free.  First you'll need to sign up for an account.  Heroku has a good
            explanation of the deployment process "
            (link-to "https://devcenter.heroku.com/articles/getting-started-with-clojure#deploy-the-app" "here") "."]

        [:p "Basically you are using the heroku command line tool to create a
            new heroku app in the same directory as your lein project.
            Install the heroku tool using "
          [:b "brew install heroku"] "."
          "You can then create your app using "
          [:b "heroku create"]
          " from your application directory."]
        [:p "This links the heroku app to your local git repository.
        Then you can push your app to heroku by simply running "
          [:b "git push heroku master"]
          ".  You'll be prompted for your heroku email and password.
          You will see the application's url printed to the console as a
          result of running that command.  The URL will contain randomly generatoed words, e.g. pure-chamber-37511.herokuapp.com.
          Try going to the url and seeing
          if your app shows up."]

        [:p "Make sure you commit your latest changes before pushing to Heroku.  You can view your logs in the command line
             by running " [:b "heroku logs"] "."]

        (link-to {:class "btn btn-primary"} "/pages/5" "< Previous page")
        (link-to {:class "btn btn-primary"} "/pages/7" "Next Page >")
        [:br]]]))

(defn source-code
  "Source Code"
  []
  (html
    (header "Source Code")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Source Code"]
        [:br]

        [:p "The full source code for this project can be found " (link-to "github.com" "here") "."]

        [:p "Here are the three files we modified in this tutorial: "]

        [:p "project.clj"
          [:p "<script src=\"https://gist.github.com/jholkeboer/abc2752c9406fd9e6403b77918c0456b.js\"></script>"]]

        [:p "core.clj"
          [:p "<script src=\"https://gist.github.com/jholkeboer/ed480641b1268f43e6c4468536705e83.js\"></script>"]]

        [:p "pages.clj"
          [:p "<script src=\"https://gist.github.com/jholkeboer/bf648e809a6b05817144c37606422383.js\"></script>"]]

        (link-to {:class "btn btn-primary"} "/pages/6" "< Previous page")
        (link-to {:class "btn btn-primary"} "/pages/1" "Start Over")
        [:br]]]))

(defn get-page
  [pagenumber]
  (cond
    (= pagenumber "1")
    (intro-page)

    (= pagenumber "2")
    (clojure-specifics)

    (= pagenumber "3")
    (setting-up-routes)

    (= pagenumber "4")
    (templating pagenumber)

    (= pagenumber "5")
    (styling)

    (= pagenumber "6")
    (deployment)

    (= pagenumber "7")
    (source-code)

    :else
    (html [:h1 "Page not found."])))
