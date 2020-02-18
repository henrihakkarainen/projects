"use strict";

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

// E12
var ToDo =
/*#__PURE__*/
function () {
  function ToDo(topic, priority) {
    _classCallCheck(this, ToDo);

    this.id = ToDo.id++;
    this.topic = topic;
    this.priority = priority;
  }

  _createClass(ToDo, [{
    key: "topic",
    set: function set(topic) {
      if (typeof topic === 'string') {
        this._topic = topic;
      } else {
        throw new TypeError('topic must be string');
      }
    },
    get: function get() {
      return this._topic;
    }
  }, {
    key: "priority",
    set: function set(priority) {
      if (priority >= 1 || priority <= 10) {
        this._priority = priority;
      } else {
        throw new TypeError('priority must be number between 1-10');
      }
    },
    get: function get() {
      return this._priority;
    }
  }]);

  return ToDo;
}();

_defineProperty(ToDo, "id", 1);

_defineProperty(ToDo, "id", 1);

var main = function main() {
  // E13
  var topics = ['Buy milk', 'Learn to code', 'Buy christmas gifts', 'Pay bills', 'Relax', 'Remember to eat', 'Remember to drink'];
  var setOfItems = new Set();
  topics.forEach(function (topic) {
    var prio = Math.floor(Math.random() * 10 + 1);
    var todoItem = new ToDo(topic, prio);
    setOfItems.add(todoItem);
  }); // Sort items by priority

  setOfItems = Array.from(setOfItems).sort(function (a, b) {
    return a.priority > b.priority ? 1 : a.priority < b.priority ? -1 : 0;
  });
  var list = document.createElement('ul');
  list.classList.add('list-group'); // Get min and max priorities

  var minPrio = Number.POSITIVE_INFINITY;
  var maxPrio = Number.NEGATIVE_INFINITY;
  setOfItems.forEach(function (item) {
    if (item.priority < minPrio) minPrio = item.priority;
    if (item.priority > maxPrio) maxPrio = item.priority;
  }); // Color list items according to their priority

  setOfItems.forEach(function (item) {
    if (item.priority === minPrio) {
      list.innerHTML += "<li class=\"list-group-item list-group-item-danger d-flex justify-content-between align-items-center\">\n                        ".concat(item.id, " - ").concat(item.topic, "\n                        <span class=\"badge badge-primary badge-pill\">").concat(item.priority, "</span>\n                       </li>");
    } else if (item.priority === maxPrio) {
      list.innerHTML += "<li class=\"list-group-item list-group-item-primary d-flex justify-content-between align-items-center\">\n                        ".concat(item.id, " - ").concat(item.topic, "\n                        <span class=\"badge badge-primary badge-pill\">").concat(item.priority, "</span>\n                       </li>");
    } else {
      list.innerHTML += "<li class=\"list-group-item list-group-item-info d-flex justify-content-between align-items-center\">\n                        ".concat(item.id, " - ").concat(item.topic, "\n                        <span class=\"badge badge-primary badge-pill\">").concat(item.priority, "</span>\n                       </li>");
    }
  });
  document.querySelector('.container').appendChild(list);
};

main();