# useful-java-snippets
Just a bunch of random things to copy and paste (maybe a little modification) to save a little time when developing applications in Java.


<h2>TransferObjects</h2>
<p>Let's face it, if we're developing an application in Java these days, it's probably going to be mostly servlets running in the cloud somewhere. The classic toString() method doesn't seem quite as useful as it once was, at least not in terms of getting data from the database and across the internet to display in a user's browser --probably dynamically altering the page with AJAX. With this in mind I created a couple of alternative data-object-to-string methods to represent the object in a string much more fitting for this modern scenario. Please note these return strings ready to be transmitted, these methods aren't writing files.</p>
<p>The methods are included in an example use-case here, but they are completely generalized, so copy and paste these over to any new class file. Haven't spent a great deal of time on this yet, some customization for the particular class may still be needed, including but not limited to: </p>

<blockquote>
  <p>I've only set it up for primitive datatypes so far, so probably still needs some customization for the particular class it's copied and pasted into.</p>

  <p>Still need to generalize arrays (JSON can handle arrays, XML needs a loop to put tags on everything), but that can easily be customized to the class structure these are copied and pasted into for now).</p>

</blockquote>


<ul>
  <li>toXML(), toXML(boolean hasHeader)</li>
    <ul>
      <li>An overloaded method to represent the object in XML form, if you need the xml header tag pass in true as the single paramater --suspected typical usage will have an array or list of data objects but only the first one will need the header tag in the transmission.</li>
      <li>Everytime I take a measurement XML and JSON seem about equivalent across the board, and if the computer's typing the tags for us, the noticable difference is that after the ajax request recieves the data in XML form we work with it using the DOM model, so it is entirely consistent with our Javascript code for working with the HTML document. Consistency is nice sometimes.</li>
    </ul>
  <li>toJSON()</li>
    <ul>
      <li>A mehtod to convert the datafields in the class to a JSON string</li>
    </ul>
  <li>toCSV() and toCSV(boolean hasHeader)</li>
    <ul>
      <li>An overloaded method to represent the datafields in CSV form, if you need a header row --I suspect typical use will be an array or list of objects to send to the csv file so the first element would need the header row included-- pass in true as the single parameter.</li>
      <li>If .csv is the form you need the data in, there are definite advantages show up to this super simple format across the board in metrics ranging from storage size to memory consumption.</li>
    </ul>
</ul>



