<form action="/users" method="post">
  <div>
    <label>
      First Name
      <input type="text" name="capFirstName" />
    </label>
  </div>
  <div>
      <label>
        Last Name
        <input type="text" name="capLastName" />
      </label>
  </div>
  <div>
    <label>
      Email
      <input type="email" required name="email" />
    </label>
  </div>
  <div>
    <label>
      Password
      <input type="password" required name="password" />
    </label>
  </div>
  <input type="submit" value="Submit" />
</form>