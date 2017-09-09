window.fn1 = () => {
  const x = {a: 1};
  const y = {...x, b: 2};
return y; };

window.React = require('react');
window.ReactDOM = require('react-dom');
window.ReactBootstrap = require('react-bootstrap');

window.Sortable = require('react-sortable-hoc');
window.SortableContainer = Sortable.SortableContainer;
window.SortableElement = Sortable.SortableElement;
