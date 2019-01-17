import {Component, OnInit, ViewChild} from '@angular/core';
import {StoreService} from '../../service/store.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Store} from '../../model/store';
import {AgmMap} from '@agm/core';

const DEFAULT_GMAP_ZOOM = 16;
const FIRST_ELEMENT_INDEX = 0;

@Component({
  selector: 'app-stores',
  templateUrl: './stores.component.html',
  styleUrls: ['./stores.component.css']
})
export class StoresComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(AgmMap) public agmMap: AgmMap;

  displayedColumns: string[];
  dataSource: MatTableDataSource<Store>;
  lat: number;
  lng: number;

  constructor(private storeService: StoreService) { }

  ngOnInit() {
    this.displayedColumns = this.defineDispColumns();
    this.assignDataSource();
    this.setAgmZoom(DEFAULT_GMAP_ZOOM);
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  private defineDispColumns(): string[] {
    return ['id', 'address'];
  }

  private assignDataSource() {
    this.storeService.getAll().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.chooseStore(data[FIRST_ELEMENT_INDEX]);
    });
  }

  chooseStore(store: Store) {
    this.initLatLng(store.xpos, store.ypos);
    this.agmMap.triggerResize();
  }

  private initLatLng(x: number, y: number) {
    this.lat = x;
    this.lng = y;
  }

  private setAgmZoom(zoom: number) {
    this.agmMap.zoom = zoom;
  }

}
