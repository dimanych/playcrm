package controllers;

import models.Contact;
import models.Contractor;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.model.contact;
import views.html.model.contacts;
import views.html.model.createContact;

import java.util.List;

import static play.data.Form.form;

/**
 * @author Dmitriy Grigoriev
 */
public class Contacts extends Controller {

  public static Result add() {
    Form<Contact> contactForm = form(Contact.class);
    return ok(createContact.render(contactForm));
  }

  public static Result save() {
    Form<Contact> contractorForm = form(Contact.class).bindFromRequest();
    if (contractorForm.hasErrors()) {
      return badRequest(contacts.render(Contact.findAll()));
    }
    contractorForm.get().save();
    return ok(contacts.render(Contact.findAll()));
  }

  public static Result contacts() {
    return ok(contacts.render(Contact.findAll()));
  }

  public static Result contact(Long id) {
    return ok(contact.render(Contact.findById(id)));
  }
}
