import { MatPaginatorIntl } from '@angular/material';

export class MatPaginatorIntlCus extends MatPaginatorIntl {

  itemsPerPageLabel = 'Rekordów na stronę:';
  nextPageLabel = 'Następna strona';
  previousPageLabel = 'Poprzednia strona';

  getRangeLabel = function (page, pageSize, length) {
    if (length === 0 || pageSize === 0) {
      return '0 z' + length;
    }

    length = Math.max(length, 0);
    const startIndex = page * pageSize;
    const endIndex = startIndex < length ?
      Math.min(startIndex + pageSize, length) :
      startIndex + pageSize;

    return startIndex + 1 + ' - ' + endIndex + ' z ' + length;
  };

}
