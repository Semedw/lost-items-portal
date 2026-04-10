const PHONE_NUMBER_REGEX =
  /^[+]?[(]?[0-9]{1,4}[)]?[-\s.]?[(]?[0-9]{1,4}[)]?[-\s.]?[0-9]{1,9}$/;

export const isValidPhoneNumber = (phone: string) =>
  PHONE_NUMBER_REGEX.test(phone);
